package com.db.grad.javaapi.service;

import com.db.grad.javaapi.exception.ResourceNotFoundException;
import com.db.grad.javaapi.model.Security;
import com.db.grad.javaapi.model.Trade;
import com.db.grad.javaapi.repository.SecurityRepository;
import com.db.grad.javaapi.repository.TradeRepository;
import com.db.grad.javaapi.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class TradeService {
    
    
    @Autowired
    private TradeRepository tradeResository;
    
    private String generateUniqueID() {
        Utils utils = new Utils();
        return utils.generateRandomString(8);
    }
    
    public Trade createTrade(Trade trade){
        
        Trade trade1 = new Trade(trade);
        trade1.setTradePublicId(generateUniqueID());
        return tradeResository.save(trade1);
    }
    
    public  Trade getTrade(String tradePublicId){
        return tradeResository.findByTradePublicId(tradePublicId).get();
    }
    
    public Security getSecurity(String tradePublicId){
        return tradeResository.findSecurityByTradePublicId(tradePublicId);
    }
    
    public Trade updateTrade(String tradePublicId,Trade trade) throws ResourceNotFoundException {
        Optional<Trade> tradeOptional = tradeResository.findByTradePublicId(tradePublicId);
        if(tradeOptional.isEmpty())throw new ResourceNotFoundException("Resource Does not exist");
        Trade trade1  = tradeOptional.get();
        Trade tr = new Trade(trade);
        tr.setTradePrivateID(trade1.getTradePrivateID());
        tr.setTradePublicId(tradePublicId);
        return tradeResository.save(tr);
    }
    
}

