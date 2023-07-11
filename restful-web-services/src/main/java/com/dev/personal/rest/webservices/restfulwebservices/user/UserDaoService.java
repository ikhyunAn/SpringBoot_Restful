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
    private static int usersCount = 0;

    static {
        users.add(new User(++usersCount, "Person1", LocalDate.now().minusYears(30)));
        users.add(new User(++usersCount, "Person2", LocalDate.now().minusYears(25)));
        users.add(new User(++usersCount, "Person3", LocalDate.now().minusYears(20)));

    }
    public List<User> findAll() {
        return users;
    }

    /**
     *
     * @param user
     * @return user
     */
    public User save(User user) {
        user.setId(++usersCount);
        users.add(user);
        return user;
    }
    public User findOne(int id) {
        /*
        take in a list
        convert to stream
        filtering based on a predicate (which checks if the id matches)

        Tips
        orElse(): returns <other> in case unexpected input is received
         */
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        return users.stream().filter(predicate).findFirst().orElse(null);
    }
    public void deleteById(int id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        users.removeIf(predicate);
    }
}
