package com.dev.personal.rest.webservices.restfulwebservices.user;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserDaoService {
    // use JPA/ Hibernate to talk to DB
    // UserDaoService > Static List
    private static List<User> users = new ArrayList<>();
    static {
        users.add(new User(1, "Person1", LocalDate.now().minusYears(30)));
        users.add(new User(2, "Person2", LocalDate.now().minusYears(25)));
        users.add(new User(3, "Person3", LocalDate.now().minusYears(20)));

    }
    public List<User> findAll() {
        return users;
    }
}
