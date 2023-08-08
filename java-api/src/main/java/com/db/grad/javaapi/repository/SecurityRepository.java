package com.db.grad.javaapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.db.grad.javaapi.model.Security;

import java.util.Optional;

@Repository
public interface SecurityRepository extends JpaRepository<Security, Long>{

        Optional<Security> findBySecurityPublicId(String publicId);
}