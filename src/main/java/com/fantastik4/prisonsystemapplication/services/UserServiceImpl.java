package com.fantastik4.prisonsystemapplication.services;

import com.fantastik4.prisonsystemapplication.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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
}
