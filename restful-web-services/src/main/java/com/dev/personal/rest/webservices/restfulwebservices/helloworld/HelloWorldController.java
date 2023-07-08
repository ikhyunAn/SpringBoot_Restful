package com.dev.personal.rest.webservices.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.*;

//REST API
@RestController
public class HelloWorldController {
    @RequestMapping(method = RequestMethod.GET, path = "/hello-world")
    public String helloWorld() {
        return "Hello World";
    }
    @GetMapping(path = "/hello-world-bean") // using GetMapping can replace "method = "
    public HelloWorldBean helloWorldBean() {
        return new HelloWorldBean("Hello World");
    }
    @GetMapping(path = "/hello-world/path-variable/{name}") // using GetMapping can replace "method = "
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
        return new HelloWorldBean(String.format("Hello World, %s", name));
    }
}
