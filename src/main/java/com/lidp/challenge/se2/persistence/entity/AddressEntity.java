package com.lidp.challenge.se2.persistence.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "address")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String street;
    private String city;
    private String state;
    private String zipCode;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    @JsonBackReference
    private CustomerEntity customer;
}