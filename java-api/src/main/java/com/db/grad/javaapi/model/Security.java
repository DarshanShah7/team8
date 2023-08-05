package com.db.grad.javaapi.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "securities")
public class Security {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "security_private_id")
    private Long securityPrivateId;
    
    @NotNull
    @Column(name = "security_public_id")
    private String securityPublicId;
    
    @NotNull
    @Column(name = "issuer")
    private String issuer;
    
    @NotNull
    @Column(name = "maturity_date")
    private Date maturityDate;
    
    @NotNull
    @Column(name = "coupon")
    private Long coupon;
    
    //ToDo: create an enum type of security type and use it over here
    @NotNull
    @Column(name = "type")
    private String type;
    @NotNull
    @Column(name = "faceValue")
    private Long faceValue;
    
    //TODo: create an enum of type security status and use it over here.
    @NotNull
    @Column(name = "status")
    private String status;
    
    @Column(name = "trade_list")
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "security", fetch = FetchType.LAZY)
    private List<Trade> tradeList;
    
    public Long getSecurityPrivateId() {
        return securityPrivateId;
    }
    
    public void setSecurityPrivateId(Long securityPrivateId) {
        this.securityPrivateId = securityPrivateId;
    }
    
    @JsonManagedReference
    public List<Trade> getTradeList() {
        return tradeList;
    }
    
    public void setTradeList(List<Trade> tradeList) {
        this.tradeList = tradeList;
    }
    
    public String getSecurityPublicId() {
        return securityPublicId;
    }
    
    public void setSecurityPublicId(String securityPublicId) {
        this.securityPublicId = securityPublicId;
    }
    
    public String getIssuer() {
        return issuer;
    }
    
    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }
    
    public Date getMaturityDate() {
        return maturityDate;
    }
    
    public void setMaturityDate(Date maturityDate) {
        this.maturityDate = maturityDate;
    }
    
    public Long getCoupon() {
        return coupon;
    }
    
    public void setCoupon(Long coupon) {
        this.coupon = coupon;
    }
    
    public String getType() {
        return type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    public Long getFaceValue() {
        return faceValue;
    }
    
    public void setFaceValue(Long faceValue) {
        this.faceValue = faceValue;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
}
