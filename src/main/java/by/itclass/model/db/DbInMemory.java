package by.itclass.model.db;

import by.itclass.model.entitty.User;

import java.util.ArrayList;
import java.util.List;

public class DbInMemory {
    private static List<User> users = new ArrayList<>();
    static {
        users.add(new User(1, "Vasia Pupcin", "vasia.pup@gmail.com"));
        users.add(new User(2, "Ivan Ivanov", "ivan.van@mail.ru"));
        users.add(new User(3, "Petr Petrov", "petr.petruha25@gmail.com"));
        users.add(new User(4, "Dima Medved", "dimon.bear@yandex.ru"));
    }

    public static boolean isContainsInDb(String fio){
        return users.stream()
                .anyMatch(it->fio.equalsIgnoreCase(it.getFio()));
    }
}