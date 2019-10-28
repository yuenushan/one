package com.example.boot.bootspringdatajpa.services.impl;

import com.example.boot.bootspringdatajpa.services.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransactionService {

    @Autowired
    private IAccountService accountService;

    @Transactional(isolation = Isolation.READ_COMMITTED)
    public void saveMoney(Long accountId, Double money) throws InterruptedException {
        synchronized (this) {
//            // READ_UNCOMMITTED
//            Thread.sleep(1000);
//            System.out.println("before save money");
//            this.notifyAll();
//            accountService.saveMoney(accountId, money);
//            System.out.println("after save money");
//            this.wait();

            // READ_COMMITTED
            this.wait();
            System.out.println("before save money");
            accountService.saveMoney(accountId, money);
            System.out.println("after save money");
            this.notifyAll();
        }
    }

    @Transactional(isolation = Isolation.READ_COMMITTED)
    public void viewMoney(Long accountId) throws InterruptedException {
        synchronized (this) {
//            // READ_UNCOMMITTED
//            System.out.println("before wait: " + accountService.viewMoney(accountId));
//            this.wait();
//            System.out.println("after wait: " + accountService.viewMoney(accountId));
//            this.notifyAll();

            // READ_COMMITTED
            Thread.sleep(1000);
            System.out.println("before wait: " + accountService.viewMoney(accountId));
            this.notifyAll();
            this.wait();
            System.out.println("after wait: " + accountService.viewMoney(accountId));
        }
    }

}
