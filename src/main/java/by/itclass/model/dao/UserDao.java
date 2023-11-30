package by.itclass.model.dao;

import by.itclass.model.db.ConnectionManager;
import by.itclass.model.entities.User;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao { // для работы с базой данных

    // private static final String Q1 = "SELECT id, fio, email FROM user WHERE fio LIKE ?";
    private static final String Q2 = "SELECT id, fio, email FROM user WHERE id>=? AND id<=?";

    // ищет по имени,  нам нуже например 1 любой объект
    public User findUserByName(String name) {
        try (Connection cn = ConnectionManager.getConnection()) {
            Statement st = cn.createStatement();
            //  String query = "SELECT id, fio, email FROM user WHERE fio LIKE" + name;
            String query = String.format("SELECT id, fio, email FROM user WHERE fio LIKE '%s'", name);
            // '%s' - '' делает строкой!!!!!
            ResultSet resultSet = st.executeQuery(query);
            if (resultSet.next()) { // if -  если хотим получить одного , если что-то есть,,,,
                int id = resultSet.getInt("id");
                String email = resultSet.getString("email");
                return new User(id, name, email);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // ищет по id диапазону, может быть много объектов
    public List<User> findUsersByIds(int from, int to) {
        List<User> users = new ArrayList<>(); //если что вернет пустую коллекцию
        try (Connection cn = ConnectionManager.getConnection();
             PreparedStatement ps = cn.prepareStatement(Q2)) {
            ps.setInt(1, from);
            ps.setInt(2, to);
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) { //  while - если много
                int id = resultSet.getInt("id");
                String fio = resultSet.getString("fio");
                String email = resultSet.getString("email");
                users.add(new User(id, fio, email));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }


}
