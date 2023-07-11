package com.dev.personal.rest.webservices.restfulwebservices.user;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
        User user = service.findOne(id);
        if (user == null) {
            throw new UserNotFoundException("id: " + id);
        }
        return user;
    }
    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        /*
        @RequestBody annotation indicates that the method should be bound to the body of the web request.
        The body of the request is passed through an HttpMessageConverter

        Tips:
        use Chrome extension: "Talend API" to test POST / GET APIs

        Expected output:
        200 (stands for success)
         */
        User savedUser = service.save(user);
        /*
        ResponseEntity class
            allows you to customize response status code
                created = 201
            location can return the location of the newly created resource
            build creates an actual instance of ResponseEntity
         */
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();

        return ResponseEntity.created(location).build();   // returns 201 message (created)
    }
    @DeleteMapping ("/users/{id}")
    public void deleteUser(@PathVariable int id){
        service.deleteById(id);
    }
}
