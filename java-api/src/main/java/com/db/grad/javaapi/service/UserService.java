package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Book;
import com.db.grad.javaapi.model.BookUser;
import com.db.grad.javaapi.model.User;
import com.db.grad.javaapi.repository.BookRepository;
import com.db.grad.javaapi.repository.BookUserRepository;
import com.db.grad.javaapi.repository.UserRepository;
import com.db.grad.javaapi.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    private UserRepository userRepository;
    
    private BookUserRepository bookUserRepository;
    
    private BookRepository bookRepository;
    
    @Autowired
    private UserService(UserRepository userRepository, BookRepository bookRepository, BookUserRepository bookUserRepository){
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
        this.bookUserRepository = bookUserRepository;
    }
    
    private String generateUniqueID() {
        Utils utils = new Utils();
        return utils.generateRandomString(8);
    }
    
    public User saveUser(User user){
        User user1 = new User(user);
        user1.setUserPublicId(generateUniqueID());
        Book book = new Book();
        book.setBookName(user1.getUserPublicId()+"_book");
        book.setBookPublicId(generateUniqueID());
        bookRepository.save(book);
        BookUser bookUser = new BookUser(user1,book);
        bookUserRepository.save(bookUser);
        return this.userRepository.save(user);
    }
    
}
