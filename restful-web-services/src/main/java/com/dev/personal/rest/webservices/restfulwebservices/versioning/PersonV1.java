package com.dev.personal.rest.webservices.restfulwebservices.versioning;

public class PersonV1 {
    public String name;
    public PersonV1(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "PersonV1{" +
                "name='" + name + '\'' +
                '}';
    }
}
