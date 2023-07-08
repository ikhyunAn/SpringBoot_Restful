package com.dev.personal.rest.webservices.restfulwebservices.user;
import org.hibernate.annotations.Comment;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
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
    public User findOne(int id) {
        /*
        take in a list
        convert to stream
        filtering based on a predicate (which checks if the id matches)
         */
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        return users.stream().filter(predicate).findFirst().get();
    }
}
