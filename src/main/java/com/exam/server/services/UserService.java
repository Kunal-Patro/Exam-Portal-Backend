package com.exam.server.services;

import com.exam.server.models.User;
import com.exam.server.models.UserRole;
import org.springframework.stereotype.Service;

import java.util.Set;
public interface UserService {
    // creating new user
    User createUser(User user, Set<UserRole> userRole) throws Exception;
}
