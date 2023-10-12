package com.home.services;


import com.amazonaws.services.identitymanagement.AmazonIdentityManagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class IAMService {


    @Autowired
    AmazonIdentityManagement iamClient;

    public List<String> getAllUsers() {
        return iamClient.listUsers().getUsers().stream().map(user->user.getUserId()).collect(Collectors.toList());
    }
}
