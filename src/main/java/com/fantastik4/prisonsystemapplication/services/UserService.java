package com.fantastik4.applicationtier.services;

import com.fantastik4.applicationtier.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User getUser(String username);
}
