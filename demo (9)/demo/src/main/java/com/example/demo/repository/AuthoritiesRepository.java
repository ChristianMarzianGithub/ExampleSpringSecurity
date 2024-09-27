package com.example.demo.repository;

import com.example.demo.model.AuthoritiesBE;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthoritiesRepository extends CrudRepository<AuthoritiesBE, Long> {
}
