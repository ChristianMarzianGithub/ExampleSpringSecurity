package com.example.demo.repository;

import com.example.demo.model.CustomerBE;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends CrudRepository<CustomerBE, Long> {
    Optional<CustomerBE> findByEmail(String email);
}