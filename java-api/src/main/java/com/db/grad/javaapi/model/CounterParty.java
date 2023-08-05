package com.db.grad.javaapi.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "counterparties")
public class CounterParty {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "counterparty_private_id")
    private Long counterPartyPrivateId;
    
    @NotNull
    @Column(name = "counterparty_public_id")
    private String counterPartyPublicId;
    
    @NotNull
    @Column(name = "name")
    private String name;
    
    @Column(name = "trade_list")
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "counterParty", fetch = FetchType.LAZY)
    private List<Trade> tradeList;
    
    public Long getCounterPartyPrivateId() {
        return counterPartyPrivateId;
    }
    
    public void setCounterPartyPrivateId(Long counterPartyPrivateId) {
        this.counterPartyPrivateId = counterPartyPrivateId;
    }
    
    public String getCounterPartyPublicId() {
        return counterPartyPublicId;
    }
    
    public void setCounterPartyPublicId(String counterPartyPublicId) {
        this.counterPartyPublicId = counterPartyPublicId;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    @JsonManagedReference
    public List<Trade> getTradeList() {
        return tradeList;
    }
    
    public void setTradeList(List<Trade> tradeList) {
        this.tradeList = tradeList;
    }
}
