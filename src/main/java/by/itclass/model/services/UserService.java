package by.itclass.model.services;

import by.itclass.model.db.DbInMemory;
import by.itclass.model.entities.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class UserService {
    public List<User> getUsersByCriteria(Map<String, String[]> params) {
        List<User> users = new ArrayList<>();
        String criteria = params.get("criteria")[0]; //получим что-то одно или name или id
        switch (criteria) {
            case "name": {
                String name = params.get("fio")[0];
                users.add(DbInMemory.findUserByName(name));
                users = users.stream()
                        .filter(Objects::nonNull) // it != null
                        .collect(Collectors.toList());
                break;
            }
            case "id": {
                int from = Integer.parseInt(params.get("fromId")[0]);
                int to = Integer.parseInt(params.get("toId")[0]);
                users=DbInMemory.findUsersByIds(from,to);
                break;
            }
        }
        return users;

    }
}
