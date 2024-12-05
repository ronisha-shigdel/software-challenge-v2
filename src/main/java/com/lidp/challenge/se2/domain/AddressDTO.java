package com.lidp.challenge.se2.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO {

    private int id;
    private String street;
    private String city;
    private String state;
    private String zipCode;
}
