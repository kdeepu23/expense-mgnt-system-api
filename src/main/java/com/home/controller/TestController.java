package com.home.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/welcome")
    public String test(){
        return "***** Welcome To Sweet Home *****";
    }

}
