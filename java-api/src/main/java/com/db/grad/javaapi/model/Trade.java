package com.db.grad.javaapi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "trades")
public class Trade {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "trade_private_id")
    private Long tradePrivateID;
    
   
    @Column(name = "trade_public_id")
    private String tradePublicId;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "book_private_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Book book;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "security_private_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Security security;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "counterparty_private_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private CounterParty counterParty;
    
    @NotNull
    @Column(name = "quantity")
    private Long quantity;
    
    //    ToDo:  Create an Enum for trade status
    @NotNull
    @Column(name = "status")
    private String status;
    
    @NotNull
    @Column(name = "price")
    private Long price;
    
    @NotNull
    @Column(name = "trade_date")
    private Date tradeDate;
    
    @NotNull
    @Column(name = "settlement_date")
    private Date settlementDate;
    
    public Trade() {
    }
    
    public Trade(Trade trade){
        
        this.book = trade.getBook();
        this.security = trade.getSecurity();
        this.counterParty = trade.getCounterParty();
        this.quantity = trade.getQuantity();
        this.status = trade.getStatus();
        this.price = trade.getPrice();
        this.tradeDate = trade.getTradeDate();
        this.settlementDate = trade.getSettlementDate();
    }
    
    public Long getTradePrivateID() {
        return tradePrivateID;
    }
    
    public void setTradePrivateID(Long tradePrivateID) {
        this.tradePrivateID = tradePrivateID;
    }
    
    @JsonBackReference
    public CounterParty getCounterParty() {
        return counterParty;
    }
    
    public void setCounterParty(CounterParty counterParty) {
        this.counterParty = counterParty;
    }
    
    public String getTradePublicId() {
        return tradePublicId;
    }
    
    public void setTradePublicId(String tradePublicId) {
        this.tradePublicId = tradePublicId;
    }
    
    public Long getQuantity() {
        return quantity;
    }
    
    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public Long getPrice() {
        return price;
    }
    
    public void setPrice(Long price) {
        this.price = price;
    }
    
    public Date getTradeDate() {
        return tradeDate;
    }
    
    public void setTradeDate(Date tradeDate) {
        this.tradeDate = tradeDate;
    }
    
    public Date getSettlementDate() {
        return settlementDate;
    }
    
    public void setSettlementDate(Date settlementDate) {
        this.settlementDate = settlementDate;
    }
    
    @JsonBackReference(value = "book-reference")
    public Book getBook() {
        return book;
    }
    
    public void setBook(Book book) {
        this.book = book;
    }
    
    @JsonBackReference(value = "security")
    public Security getSecurity() {
        return security;
    }
    
    public void setSecurity(Security security) {
        this.security = security;
    }
}
