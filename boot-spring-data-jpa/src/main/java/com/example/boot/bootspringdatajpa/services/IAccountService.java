package com.example.boot.bootspringdatajpa.services;

public interface IAccountService {
    void transferMoney(Long sourceAccountId, Long targetAccountId, Double money);
    Long createAccount(String name);
    Double saveMoney(Long accountId, Double money);
    Double takeMoney(Long accountId, Double money);
    Double viewMoney(Long accountId);
}
