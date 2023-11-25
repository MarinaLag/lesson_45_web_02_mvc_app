package by.itclass.model.db;

import by.itclass.model.entitty.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DbInMemory {
    private static List<User> users = new ArrayList<>();
    static {
        users.add(new User(1, "Vasia Pupcin", "vasia.pup@gmail.com"));
        users.add(new User(2, "Ivan Ivanov", "ivan.van@mail.ru"));
        users.add(new User(3, "Petr Petrov", "petr.petruha25@gmail.com"));
        users.add(new User(4, "Dima Medved", "dimon.bear@yandex.ru"));
    }
//метод проверяет, есть ли такая фамилия
    public static boolean isContainsInDb(String fio){
        return users.stream()
                .anyMatch(it->fio.equalsIgnoreCase(it.getFio()));
    }

    public static User findUserByName(String name){
       return users.stream()
                .filter(it->it.getFio().equalsIgnoreCase(name))
                .findFirst() // возвращает optional
                .orElse(null);
    }

    public static List<User> findUsersByIds(int from, int to){
        return users.stream()
                .filter(it->it.getId() >= from && it.getId() <= to)
                .collect(Collectors.toList());
    }
}
