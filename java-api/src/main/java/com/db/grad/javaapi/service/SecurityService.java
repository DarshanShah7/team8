package com.db.grad.javaapi.service;

import com.db.grad.javaapi.exception.ResourceNotFoundException;
import com.db.grad.javaapi.model.Security;
import com.db.grad.javaapi.repository.SecurityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class SecurityService {
    @Autowired
    private SecurityRepository securityRepository;
    public List<Security> getAllSecurity()
    {
        return securityRepository.findAll();
    }
    
    public Security findSecurityById(long id ) throws ResourceNotFoundException
    {
//        Security security = securityRepository.findBy(id).orElseThrow(() -> new ResourceNotFoundException("Security not found for this id :: " + id));
       Security sec = new Security();
        return sec;
    }
    
    public Security saveSecurity(Security security )
    {
        return securityRepository.saveAndFlush(security);
    }
    
    public Security updateSecurityDetails( String id, Security newSecurityDetails ) throws ResourceNotFoundException
    {
        Security securityToUpdate = securityRepository.findBySecurityPublicId(id)
                .orElseThrow(() -> new ResourceNotFoundException("Security not found for this id :: " + id));
        
        securityToUpdate.setSecurityPrivateId(newSecurityDetails.getSecurityPrivateId());
        securityToUpdate.setTradeList(newSecurityDetails.getTradeList());
        securityToUpdate.setSecurityPublicId(newSecurityDetails.getSecurityPublicId());
        securityToUpdate.setIssuer(newSecurityDetails.getIssuer());
        securityToUpdate.setMaturityDate(newSecurityDetails.getMaturityDate());
        securityToUpdate.setCoupon(newSecurityDetails.getCoupon());
        securityToUpdate.setType(newSecurityDetails.getType());
        securityToUpdate.setFaceValue(newSecurityDetails.getFaceValue());
        securityToUpdate.setStatus(newSecurityDetails.getStatus());
        final Security updatedSecurity = securityRepository.save(securityToUpdate);
        return updatedSecurity;
    }
    
    public Security deleteTheSecurity( String id ) throws ResourceNotFoundException
    {
        Security security = securityRepository.findBySecurityPublicId(id)
                .orElseThrow(() -> new ResourceNotFoundException("Security not found for this id :: " + id));
        
        securityRepository.delete(security);
        
        return security;
    }

    public List<Security> findByMaturityDateBetween(Date startDate, Date endDate) {
        return securityRepository.findByMaturityDateBetween(startDate, endDate);
    }
}