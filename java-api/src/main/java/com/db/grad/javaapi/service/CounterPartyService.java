package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.CounterParty;
import com.db.grad.javaapi.model.Trade;
import com.db.grad.javaapi.repository.CounterPartyRepository;
import com.db.grad.javaapi.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CounterPartyService {
    
    @Autowired
    private CounterPartyRepository counterPartyRepository;
    
    private String generateUniqueID() {
        Utils utils = new Utils();
        return utils.generateRandomString(8);
    }
    
    public CounterParty createCounterParty(CounterParty counterParty){
        
        CounterParty counterParty1 = new CounterParty(counterParty);
        counterParty1.setCounterPartyPublicId(generateUniqueID());
        return counterPartyRepository.save(counterParty1);
    }
}
