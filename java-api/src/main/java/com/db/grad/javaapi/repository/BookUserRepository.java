package com.db.grad.javaapi.repository;

import com.db.grad.javaapi.model.BookUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookUserRepository extends JpaRepository<BookUser, Long> {
    
    List<BookUser> findByUserUserPrivateId(Long userPrivateId);
    
    BookUser findByBookUserId(Long bookUserId);
}
