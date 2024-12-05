package com.lidp.challenge.se2.service;

import com.lidp.challenge.se2.persistence.dao.SalesRepository;
import com.lidp.challenge.se2.persistence.entity.SalesEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class SalesService {

    private final SalesRepository salesRepository;

    public SalesService(SalesRepository salesRepository) {
        this.salesRepository = salesRepository;
    }

    public BigDecimal getTotalSalesByDateRange(LocalDate startDate, LocalDate endDate) {
        return salesRepository.findBySaleDateBetween(startDate, endDate).stream()
                .map(SalesEntity::getSaleAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal getTotalSalesByCustomer(Integer customerId) {
        return salesRepository.findByCustomerId(customerId).stream()
                .map(SalesEntity::getSaleAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public List<SalesEntity> getSalesDataForGraph(LocalDate startDate, LocalDate endDate) {
        return salesRepository.findBySaleDateBetween(startDate, endDate);
    }
}
