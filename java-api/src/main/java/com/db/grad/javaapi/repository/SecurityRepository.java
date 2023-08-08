package com.db.grad.javaapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.db.grad.javaapi.model.Security;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface SecurityRepository extends JpaRepository<Security, Long>{
    List<Security>  findByMaturityDateBetween(Date startDate, Date endDate);
}