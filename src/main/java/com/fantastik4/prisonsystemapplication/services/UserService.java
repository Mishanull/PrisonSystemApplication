package com.fantastik4.prisonsystemapplication.services;

import com.fantastik4.prisonsystemapplication.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User getUser(String username);
}
