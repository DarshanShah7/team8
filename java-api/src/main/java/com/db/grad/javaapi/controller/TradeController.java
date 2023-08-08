package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.exception.ResourceNotFoundException;
import com.db.grad.javaapi.model.Security;
import com.db.grad.javaapi.model.Trade;
import com.db.grad.javaapi.model.User;
import com.db.grad.javaapi.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/trade")
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:8080"})
public class TradeController {
    
    
    private TradeService tradeService;
    
    @Autowired
    public TradeController(TradeService tradeService){
        this.tradeService = tradeService;
    }
    
    @PostMapping("/create-trade")
    public Trade createTrade(@Valid @RequestBody Trade  trade) {
        return tradeService.createTrade(trade);
    }
    
    @GetMapping("/get-trade/{tradePublicId}")
    public Trade getTrade(@PathVariable String tradePublicId){
        return tradeService.getTrade(tradePublicId);
    }
    
    @GetMapping("/get-security/{tradePublicId}")
    public Security getSecurity(@PathVariable String tradePublicId){
        return tradeService.getSecurity(tradePublicId);
    }
    
    @PutMapping("/update-trade/{tradePublicId}")
    public Trade updateTrade(@PathVariable String tradePublicId, @RequestBody @Valid Trade trade) throws ResourceNotFoundException {
        return tradeService.updateTrade(tradePublicId,trade);
    }
}


