package com.example.boot.bootspringdatajpa.services.impl;

import com.example.boot.bootspringdatajpa.services.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles(value = "unittest")
public class TransactionServiceTest {
    @Autowired
    private TransactionService transactionService;
    @Autowired
    private IAccountService accountService;
    @Autowired
    private DataSource dataSource;

    @Test
    public void test2() {
        System.out.println(dataSource);
    }

    @Test
    public void test() throws InterruptedException {
        Long accountId = accountService.createAccount("david");
        Thread viewMoneyThread = new ViewMoneyThread(accountId);
        Double saveMoney = 1000d;
        Thread saveMoneyThread = new SaveMoneyThread(accountId, saveMoney);
        viewMoneyThread.start();
        saveMoneyThread.start();
        viewMoneyThread.join();
        assertEquals(saveMoney, accountService.viewMoney(accountId));
    }

    class SaveMoneyThread extends Thread{

        private Long accountId;
        private Double money;

        public SaveMoneyThread(Long accountId, Double money) {
            this.accountId = accountId;
            this.money = money;
        }

        @Override
        public void run() {
            try {
                transactionService.saveMoney(accountId, money);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    class ViewMoneyThread extends Thread {

        private Long accountId;

        public ViewMoneyThread(Long accountId) {
            this.accountId = accountId;
        }

        @Override
        public void run() {
            try {
                transactionService.viewMoney(accountId);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
