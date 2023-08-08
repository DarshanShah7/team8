package com.db.grad.javaapi.repository;

import com.db.grad.javaapi.model.Security;
import com.db.grad.javaapi.model.Trade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface TradeRepository extends JpaRepository<Trade,Long> {

    Optional<Trade>findByTradePublicId(String tradePublicId);
    
    
    @Query("SELECT t.security FROM Trade t WHERE t.tradePublicId = :tradePublicId")
    Security findSecurityByTradePublicId(@Param("tradePublicId")String tradePublicId);
}
