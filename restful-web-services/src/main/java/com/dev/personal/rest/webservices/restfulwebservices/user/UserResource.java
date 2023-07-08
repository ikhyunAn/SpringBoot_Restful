package com.dev.personal.rest.webservices.restfulwebservices.user;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class UserResource {
    private UserDaoService service;
    public UserResource(UserDaoService service) {
        this.service = service;
    }

    // Get /users
    @GetMapping("/users")
    public List<User> retrieveAllUsers(){
        return service.findAll();
    }
    @GetMapping("/users/{id}")
    public User retrieveUser(@PathVariable int id){
        return service.findOne(id);
    }

    @PostMapping("/users")
    public void createUser(@RequestBody User user) {
        /*
        @RequestBody annotation indicates that the method should be bound to the body of the web request.
        The body of the request is passed through an HttpMessageConverter

        Tips:
        use Chrome extension: "Talend API" to test POST / GET APIs

        Expected output:
        200 (stands for success)
         */
        service.save(user);
    }
}
