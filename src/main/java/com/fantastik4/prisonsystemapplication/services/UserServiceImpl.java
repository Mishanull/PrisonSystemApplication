package com.fantastik4.prisonsystemapplication.services;

import com.fantastik4.prisonsystemapplication.model.Guard;
import com.fantastik4.prisonsystemapplication.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@Service
public class UserServiceImpl implements UserService {
    private RestTemplate restTemplate;


    @Autowired
    public UserServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public User getUser(String username) {
        try {
            return restTemplate.getForObject("https://localhost:7150/User/{username}", User.class, username);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    @Override
    public User getUserById(Long id) {
        try {
            return restTemplate.getForObject("https://localhost:7150/User/GetById/{id}", User.class, id);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
