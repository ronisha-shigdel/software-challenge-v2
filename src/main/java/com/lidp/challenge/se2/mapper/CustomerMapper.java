package com.lidp.challenge.se2.mapper;

import com.lidp.challenge.se2.domain.AddressDTO;
import com.lidp.challenge.se2.domain.CustomerDTO;
import com.lidp.challenge.se2.persistence.entity.AddressEntity;
import com.lidp.challenge.se2.persistence.entity.CustomerEntity;

import java.util.List;

public interface CustomerMapper {

    static CustomerEntity toEntity(CustomerDTO dto) {
        List<AddressDTO> addresses = dto.getAddresses();

        CustomerEntity entity = CustomerEntity.builder()
                .name(dto.getName())
                .id(dto.getId())
                .build();
        if (addresses != null) {
            entity.setAddresses(addresses.stream()
                    .map(address -> toEntity(address, entity))
                    .toList());
        }
        return entity;
    }

    static AddressEntity toEntity(AddressDTO addressDto, CustomerEntity customerEntity) {

        return
                AddressEntity.builder()
                        .id(addressDto.getId())
                        .street(addressDto.getStreet())
                        .city(addressDto.getCity())
                        .state(addressDto.getState())
                        .zipCode(addressDto.getZipCode())
                        .customer(customerEntity)
                        .build();
    }

    static CustomerDTO toDto(CustomerEntity entity) {
        List<AddressEntity> addresses = entity.getAddresses();

        CustomerDTO dto = CustomerDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();

        if (addresses != null) {
            dto.setAddresses(addresses.stream()
                    .map(CustomerMapper::toDto) // Use AddressMapper to map AddressEntity to AddressDTO
                    .toList());
        }

        return dto;
    }

    static AddressDTO toDto(AddressEntity entity) {
        return AddressDTO.builder()
                .id(entity.getId())
                .street(entity.getStreet())
                .city(entity.getCity())
                .state(entity.getState())
                .zipCode(entity.getZipCode())
                .build();
    }

}
