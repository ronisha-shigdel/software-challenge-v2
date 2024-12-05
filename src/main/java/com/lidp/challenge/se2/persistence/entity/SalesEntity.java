package com.lidp.challenge.se2.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;


@Entity
@Table(name = "sales")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SalesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "customerId", nullable = false)
    private Integer customerId;

    @Column(name = "productName", nullable = false, columnDefinition = "VARCHAR(255)")
    private String productName;

    @Column(name = "saleAmount", precision = 10, scale = 2)
    private BigDecimal saleAmount;

    @Column(name = "saleDate")
    private LocalDate saleDate;
}