package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.model.Security;
import com.db.grad.javaapi.model.User;

import com.db.grad.javaapi.service.UserService;
import com.db.grad.javaapi.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:8080"})
public class UserController {
    
    
    private UserService userService;
    
    @Autowired
    public UserController(UserService ss) {
        this.userService = ss;
    }
    
    private String generateUniqueID() {
        Utils utils = new Utils();
        return utils.generateRandomString(8);
    }
    @PostMapping("/create-user")
    public User createUser(@Valid @RequestBody User  user) {
        User user1 = new User(user);
        user.setUserPublicId(generateUniqueID());
        return userService.saveUser(user);
    }
    
}
