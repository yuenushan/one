package com.example.boot.bootspringdatajpa.repository;

import com.example.boot.bootspringdatajpa.domain.CustomerDoamin;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<CustomerDoamin, Long> {

    List<CustomerDoamin> findByLastName(String lastName);

    CustomerDoamin findById(long id);
}
