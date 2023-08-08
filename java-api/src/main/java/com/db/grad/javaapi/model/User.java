package com.db.grad.javaapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_private_id")
    private Long userPrivateId;
    
    @Column(name = "user_public_id")
    private String userPublicId;
    
    @NotNull
    @Column(name = "name")
    private String name;
    
    @NotNull
    @Column(name = "email")
    private String email;
    
    @NotNull
    @Column(name = "role")
    private String role;
    
  
    @Column(name = "book-users")
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.LAZY)
    private List<BookUser> bookUsers;
    
    public User() {
    }
    
    public User(User user) {
        this.userPrivateId = user.userPrivateId;
        this.name = user.name;
        this.email = user.email;
        this.role = user.role;
        this.bookUsers = user.bookUsers;
    }
    
    public Long getUserPrivateId() {
        return userPrivateId;
    }
    
    public void setUserPrivateId(Long userPrivateId) {
        this.userPrivateId = userPrivateId;
    }
    
    public String getUserPublicId() {
        return userPublicId;
    }
    
    public void setUserPublicId(String userPublicId) {
        this.userPublicId = userPublicId;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getRole() {
        return role;
    }
    
    public void setRole(String role) {
        this.role = role;
    }
    
    
    @JsonManagedReference(value = "user-reference")
    public List<BookUser> getBookUsers() {
        return bookUsers;
    }
    
    public void setBookUsers(List<BookUser> bookUsers) {
        this.bookUsers = bookUsers;
    }
}
