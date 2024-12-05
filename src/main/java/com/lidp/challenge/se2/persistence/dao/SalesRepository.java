package com.lidp.challenge.se2.persistence.dao;

import com.lidp.challenge.se2.persistence.entity.SalesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface SalesRepository extends JpaRepository<SalesEntity, Integer> {

    List<SalesEntity> findBySaleDateBetween(LocalDate startDate, LocalDate endDate);

    List<SalesEntity> findByCustomerId(Integer customerId);
}
