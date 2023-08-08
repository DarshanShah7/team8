package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.model.Book;
import com.db.grad.javaapi.service.BookService;
import com.db.grad.javaapi.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:8080"})
public class BookController {
    
    
    private BookService bookService;
    
    @Autowired
    public BookController(BookService ss) {
        this.bookService = ss;
    }
    
    private String generateUniqueID() {
        Utils utils = new Utils();
        return utils.generateRandomString(8);
    }
    
    
    @GetMapping("")
    public String getBooks(){
        return "Hello World!";
        
    }
    @PostMapping("/create-book/{user-id}/{book-name}")
    public Book createBook(  @PathVariable("user-id")  Long userId ,   @PathVariable("book-name") String bookName) {
        
        return bookService.createBook(bookName,userId);
    }
    
    @GetMapping("/get-all-books/{user-id}")
    public List<Book> getAllBooks(@PathVariable("user-id")Long userId){
        return bookService.getAllBooks(userId);
    }
    
}
