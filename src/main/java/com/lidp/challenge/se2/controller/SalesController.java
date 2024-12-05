package com.lidp.challenge.se2.controller;

import com.lidp.challenge.se2.persistence.entity.SalesEntity;
import com.lidp.challenge.se2.service.SalesService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/sales")
public class SalesController {

    private final SalesService salesService;

    public SalesController(SalesService salesService) {
        this.salesService = salesService;
    }

    @GetMapping("/total-by-date")
    public BigDecimal getTotalSalesByDateRange(@RequestParam LocalDate startDate, @RequestParam LocalDate endDate) {
        return salesService.getTotalSalesByDateRange(startDate, endDate);
    }

    @GetMapping("/total-by-client")
    public BigDecimal getTotalSalesByClient(@RequestParam Integer customerId) {
        return salesService.getTotalSalesByCustomer(customerId);
    }

    @GetMapping("/graph-data")
    public List<SalesEntity> getSalesDataForGraph(@RequestParam LocalDate startDate, @RequestParam LocalDate endDate) {
        return salesService.getSalesDataForGraph(startDate, endDate);
    }
}
