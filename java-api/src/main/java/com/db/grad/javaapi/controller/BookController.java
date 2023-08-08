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
    
    @GetMapping("/get-all-books")
    public List<Book> getBooks(){
        return bookService.getAllBooks();
    }
    
    @PostMapping("/create-book/{user-id}/{book-name}")
    public Book createBook(  @PathVariable("user-id")  String userId , @PathVariable("book-name") String bookName) {
        return bookService.createBook(bookName,userId);
    }
    
    @GetMapping("/get-book-by-id/{user-id}")
    public List<Book> getBookById(@PathVariable("user-id")String userId){
        return bookService.getBookById(userId);
    }
    
}
