package by.itclass.controllers;

import by.itclass.model.db.DbInMemory;
import by.itclass.model.entitty.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@WebServlet(name = "jspUserController", urlPatterns = "/jspSearch")
public class JspUserController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("fio");
        User user = DbInMemory.findUserByName(name); // вернет или пользователя или null
        RequestDispatcher rd = req.getRequestDispatcher("/jsp/user.jsp");
        if(Objects.nonNull(user)){   // если user не null
            req.setAttribute("us", user);
        }else {
            String message  = "User by name" + name + " is not found"; // некое сообщение
            req.setAttribute("mes",message);
        }
        rd.forward(req,resp);
    }
}
