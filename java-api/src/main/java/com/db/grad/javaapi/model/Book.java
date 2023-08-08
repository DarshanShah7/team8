package com.db.grad.javaapi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
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
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "book", fetch = FetchType.EAGER)
    private List<BookUser> bookUsers = new ArrayList<>();
    @NotNull
    @Column(name = "book_public_id")
    private String bookPublicId;
    
    public Book(String bookName) {
        this.bookName = bookName;
    }
    
    public Book(Long bookPrivateId, String bookPublicId, String bookName){
        this.bookPrivateId = bookPrivateId;
        this.bookPublicId = bookPublicId;
        this.bookName = bookName;
    }
    
    public Book(){
            this.bookUsers  = new ArrayList<>();
    }
    
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
    
    @JsonManagedReference(value="book-reference")
    public List<BookUser> getBookUsers() {
        return bookUsers;
    }
    
    public void setBookUsers(List<BookUser> bookUsers) {
        this.bookUsers = bookUsers;
    }
    
    public void addBookUser(BookUser bookUser){
        this.bookUsers.add(bookUser);
    }
    
}
