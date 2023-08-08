package com.db.grad.javaapi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "book_users")
public class BookUser {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_user_id")
    private Long bookUserId;
    
    public BookUser() {
    }
    
    public BookUser(User user, Book book) {
        this.user = user;
        this.book = book;
    }
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_private_id", nullable = false)
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;
    
    public Long getBookUserId() {
        return bookUserId;
    }
    
    public void setBookUserId(Long bookUserId) {
        this.bookUserId = bookUserId;
    }
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "book_private_id", nullable = false)
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Book book;
    
    @JsonBackReference(value="book-reference")
    public Book getBook() {
        return book;
    }
    
    public void setBook(Book book) {
        this.book = book;
    }
    
    @JsonBackReference(value = "user-reference")
    public User getUser() {
        return user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    
    
}
