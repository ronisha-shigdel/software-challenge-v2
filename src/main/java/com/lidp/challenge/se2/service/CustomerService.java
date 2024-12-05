package com.lidp.challenge.se2.service;

import com.lidp.challenge.se2.domain.CustomerDTO;
import com.lidp.challenge.se2.mapper.CustomerMapper;
import com.lidp.challenge.se2.persistence.dao.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void save(final CustomerDTO customer) {
        this.customerRepository.save(CustomerMapper.toEntity(customer));
    }

    public List<CustomerDTO> findAll() {
        return this.customerRepository.findAll()
                .stream()
                .map(CustomerMapper::toDto)
                .toList();
    }

    public Optional<CustomerDTO> findById(final Integer id) {
        return this.customerRepository.findById(id)
                .map(CustomerMapper::toDto);
    }

    public void deleteById(final Integer id) {
        this.customerRepository.deleteById(id);
    }
}
