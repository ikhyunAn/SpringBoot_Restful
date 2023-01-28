package com.example.restfulwebservice.helloworld;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// lombok
@Data //lombok data is added so that properties of HelloWorldBean are given setter / getter / constructors
@AllArgsConstructor //constructor method is given
@NoArgsConstructor
public class HelloWorldBean {
    private String message;
    //getters and setters and constructors not needed thanks to lombok Data
}
