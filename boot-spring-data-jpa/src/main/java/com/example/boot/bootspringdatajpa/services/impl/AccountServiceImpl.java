package com.example.boot.bootspringdatajpa.services.impl;

import com.example.boot.bootspringdatajpa.domain.AccountDomain;
import com.example.boot.bootspringdatajpa.repository.AccountRepository;
import com.example.boot.bootspringdatajpa.services.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class AccountServiceImpl implements IAccountService {

    private AccountRepository accountRepository;

    @Autowired
    public void setAccountRepository(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Transactional
    @Override
    public void transferMoney(Long sourceAccountId, Long targetAccountId, Double money) {
        takeMoney(sourceAccountId, money);
        saveMoney(targetAccountId, money);
    }

    @Override
    public Long createAccount(String name) {
        AccountDomain accountDomain  = new AccountDomain();
        accountDomain.setName(name);
        accountDomain.setMoney(0.0);
        accountRepository.save(accountDomain);
        return accountDomain.getId();
    }

    @Override
    public Double saveMoney(Long accountId, Double money) {
        Optional<AccountDomain> accountDomainOptional = accountRepository.findById(accountId);
        if (accountDomainOptional.isPresent()) {
            AccountDomain accountDomain = accountDomainOptional.get();
            accountDomain.setMoney(accountDomain.getMoney() + money);
            accountRepository.save(accountDomain);
            return accountDomain.getMoney();
        } else {
            throw new RuntimeException("账号不存在");
        }
    }

    @Override
    public Double takeMoney(Long accountId, Double money) {
        Optional<AccountDomain> accountDomainOptional = accountRepository.findById(accountId);
        if (accountDomainOptional.isPresent()) {
            AccountDomain accountDomain = accountDomainOptional.get();
            Double remainMoney = accountDomain.getMoney() - money;
            if (remainMoney < 0) {
                throw new RuntimeException("余额不足");
            }
            accountDomain.setMoney(remainMoney);
            accountRepository.save(accountDomain);
            return accountDomain.getMoney();
        } else {
            throw new RuntimeException("账号不存在");
        }
    }

    @Override
    public Double viewMoney(Long accountId) {
        Optional<AccountDomain> accountDomainOptional = accountRepository.findById(accountId);
        if (accountDomainOptional.isPresent()) {
            return accountDomainOptional.get().getMoney();
        } else {
            throw new RuntimeException("账号不存在");
        }
    }
}
