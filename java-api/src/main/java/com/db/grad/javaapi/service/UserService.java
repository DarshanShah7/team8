package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.User;
import com.db.grad.javaapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    private UserRepository userRepository;
    
    @Autowired
    private UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    
    public User saveUser(User user){
        return this.userRepository.save(user);
    }
    
}
