package com.home.controller;

import com.home.services.IAMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("iam")
public class IAMController {

    @Autowired
    IAMService iamService;

    @GetMapping("/getAllUsers")
    public List<String> listUsers() {

        return iamService.getAllUsers();

    }
}
