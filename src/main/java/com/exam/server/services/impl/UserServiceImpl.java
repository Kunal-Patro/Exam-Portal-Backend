package com.exam.server.services.impl;

import com.exam.server.models.User;
import com.exam.server.models.UserRole;
import com.exam.server.repositories.RoleRepository;
import com.exam.server.repositories.UserRepository;
import com.exam.server.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private RoleRepository roleRepo;

    //creating user
    @Override
    public User createUser (User user, Set<UserRole> userRoles) throws Exception{
        User loc = userRepo.findByUsername(user.getUsername());
        if(loc != null)
        {
            throw new Exception("User already exist");
        }
        else {
            for(UserRole u : userRoles)
            {
                roleRepo.save(u.getRole());
            }
            user.getUserRoles().addAll(userRoles);
            loc = userRepo.save(user);
        }
        return loc;
    }
}
