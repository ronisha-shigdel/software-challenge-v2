package com.lidp.challenge.se2.persistence.dao;

import com.lidp.challenge.se2.persistence.entity.CustomerEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends CrudRepository<CustomerEntity, Integer> {

    @Override
    List<CustomerEntity> findAll();
}
