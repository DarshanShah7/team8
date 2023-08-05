package com.db.grad.javaapi.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "books")
public class Book {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_private_id")
    private Long bookPrivateId;
    
    @NotNull
    @Column(name = "book_name")
    private String bookName;
    
    @Column(name = "book-users")
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "book", fetch = FetchType.LAZY)
    private List<BookUser> bookUsers;
    @NotNull
    @Column(name = "book_public_id")
    private String bookPublicId;
    
    public Long getBookPrivateId() {
        return bookPrivateId;
    }
    
    public void setBookPrivateId(Long bookPrivateId) {
        this.bookPrivateId = bookPrivateId;
    }
    
    public String getBookPublicId() {
        return bookPublicId;
    }
    
    public void setBookPublicId(String bookPublicId) {
        this.bookPublicId = bookPublicId;
    }
    
    public String getBookName() {
        return bookName;
    }
    
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
    
    @JsonManagedReference
    public List<BookUser> getBookUsers() {
        return bookUsers;
    }
    
    public void setBookUsers(List<BookUser> bookUsers) {
        this.bookUsers = bookUsers;
    }
    
}
