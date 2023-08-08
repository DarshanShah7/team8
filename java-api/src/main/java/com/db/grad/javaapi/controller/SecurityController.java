package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.exception.ResourceNotFoundException;
import com.db.grad.javaapi.model.Security;
import com.db.grad.javaapi.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/security")
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:8080"})
public class SecurityController {
    @GetMapping("/index")
    public String index() {
        return ("Hello World");
    }
    private SecurityService securityService;
    
    @Autowired
    public SecurityController(SecurityService ss) {
        this.securityService = ss;
    }
    
    @GetMapping("/getAllSecurities")
    public List<Security> getAllSecurity() {
        return securityService.getAllSecurity();
    }
    
    @GetMapping("/getById")
    public ResponseEntity<Security> getEmployeeById( )
            throws ResourceNotFoundException {
//        return
//        Security security = securityService.findSecurityById(id);
        return ResponseEntity.ok().body(new Security());
    }
    
    @PostMapping("/create-security")
    public Security createSecurity(@Valid @RequestBody Security security) {
        return securityService.saveSecurity(security);
    }
    
    @PutMapping("/updateSecurity/{id}")
    public ResponseEntity<Security> updateSecurity(@PathVariable(value = "id") Long id,
                                                   @Valid @RequestBody Security securityDetails) throws ResourceNotFoundException {
        
        final Security updatedSecurity = securityService.updateSecurityDetails(id, securityDetails);
        return ResponseEntity.ok(updatedSecurity);
    }
    
    @DeleteMapping("/deleteSecurity/{id}")
    public Map<String, Boolean> deleteSecurity(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {
        Security dogs = securityService.deleteTheSecurity(id);
        
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}