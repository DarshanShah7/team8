package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.model.CounterParty;
import com.db.grad.javaapi.model.User;
import com.db.grad.javaapi.service.CounterPartyService;
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
    
    private CounterPartyService counterPartyService;
    
    
    
    @Autowired
    public UserController(UserService ss, CounterPartyService counterPartyService) {
        this.userService = ss;
        this.counterPartyService = counterPartyService;
    }
    
    private String generateUniqueID() {
        Utils utils = new Utils();
        return utils.generateRandomString(8);
    }
    @PostMapping("/create-user")
    public User createUser(@Valid @RequestBody User  user) {
        return userService.saveUser(user);
    }
    
    @PostMapping("/create-counterparty")
    public CounterParty createCounterParty(@Valid @RequestBody CounterParty counterParty){
        CounterParty counterParty1 = new CounterParty(counterParty);
        counterParty1.setCounterPartyPublicId(generateUniqueID());
        return counterPartyService.createCounterParty(counterParty1);
        
    }
    
}
