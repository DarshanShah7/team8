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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    
    private BookRepository bookRepository;
    
    private BookUserRepository bookUserRepository;
    
    private  UserRepository userRepository;
    
    @Autowired
    public BookService(BookRepository bookRepository, BookUserRepository bookUserRepository, UserRepository userRepository){
        this.bookRepository = bookRepository;
        this.bookUserRepository = bookUserRepository;
        this.userRepository = userRepository;
    }
    
    private String generateUniqueID() {
        Utils utils = new Utils();
        return utils.generateRandomString(8);
    }
    public Book createBook(String bookName , String userId){
        Book book = new Book(bookName);
        book.setBookPublicId(generateUniqueID());
        Book book1 = this.bookRepository.save(book);
        Optional<User> user1 = userRepository.findByUserPublicId(userId);
        BookUser bookUser = new BookUser(user1.get(), book1) ;
        book1.addBookUser(bookUser);
        bookUserRepository.save(bookUser);
        return book1;
    }
    
    public List<Book>getAllBooks(){
        return bookRepository.findAll();
    }
    
    public List<Book> getBookById(String userId){
        Long userId1 = userRepository.findByUserPublicId(userId).get().getUserPrivateId();
        List<BookUser>bookUserList =  bookUserRepository.findByUserUserPrivateId(userId1);
        List<Book>bookList = new ArrayList<>();
        for(int i = 0; i< bookUserList.size();i++){
            Book book = bookUserList.get(i).getBook();
            System.out.println(book.getBookName());
            bookList.add(new Book(book.getBookPrivateId(), book.getBookPublicId() , book.getBookName()));
        }
        return bookList;
    
    }
    
    
}
