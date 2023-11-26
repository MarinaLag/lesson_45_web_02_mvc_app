package by.itclass.controllers;

import by.itclass.model.entities.User;
import by.itclass.model.services.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "conditionsController", urlPatterns = "/criteria")
public class ConditionsController extends HttpServlet {
    //так не делают, но это пока для образца
    private UserService service;

    @Override
    public void init() throws ServletException {
        service = new UserService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String[]> params = req.getParameterMap();

        List<User> users = service.getUsersByCriteria(params);

        if (!users.isEmpty()){ // если не пустая
            req.setAttribute("users", users);
        }else {
            req.setAttribute("message", "Users is not found");
        }
        RequestDispatcher rd = req.getRequestDispatcher("/jsp/users.jsp");
        rd.forward(req,resp);
    }
}
