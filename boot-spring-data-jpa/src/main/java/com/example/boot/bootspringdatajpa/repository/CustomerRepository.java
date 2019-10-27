package com.example.boot.bootspringdatajpa.repository;

import com.example.boot.bootspringdatajpa.domain.CustomerDomain;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<CustomerDomain, Long> {

    List<CustomerDomain> findByLastName(String lastName);

    CustomerDomain findById(long id);
}
