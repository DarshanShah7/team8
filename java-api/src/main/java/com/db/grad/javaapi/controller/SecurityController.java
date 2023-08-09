package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.exception.ResourceNotFoundException;
import com.db.grad.javaapi.model.Security;
import com.db.grad.javaapi.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
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
    
//    @GetMapping("/getById/"){}
//    public ResponseEntity<Security> getEmployeeById( )
//            throws ResourceNotFoundException {
//
//        return ResponseEntity.ok().body(new Security());
//    }

    @GetMapping("/date")
    public List<Security> getSecuritiesByDateRange(
            @RequestParam String startDate,
            @RequestParam String endDate) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Date parsedStartDate = dateFormat.parse(startDate);
        Date parsedEndDate = dateFormat.parse(endDate);
        return securityService.findByMaturityDateBetween(parsedStartDate, parsedEndDate);
    }
    
    @PostMapping("/create-security")
    public Security createSecurity(@Valid @RequestBody Security security) {
        return securityService.saveSecurity(security);
    }
    
    @PutMapping("/updateSecurity/{id}")
    public ResponseEntity<Security> updateSecurity(@PathVariable(value = "id") String id,
                                                   @Valid @RequestBody Security securityDetails) throws ResourceNotFoundException {
        
        final Security updatedSecurity = securityService.updateSecurityDetails(id, securityDetails);
        return ResponseEntity.ok(updatedSecurity);
    }
    
    @DeleteMapping("/deleteSecurity/{id}")
    public Map<String, Boolean> deleteSecurity(@PathVariable(value = "id") String id)
            throws ResourceNotFoundException {
        Security dogs = securityService.deleteTheSecurity(id);
        
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}