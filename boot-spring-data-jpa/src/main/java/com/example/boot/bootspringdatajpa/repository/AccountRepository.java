package com.example.boot.bootspringdatajpa.repository;

import com.example.boot.bootspringdatajpa.domain.AccountDomain;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<AccountDomain, Long> {
}
