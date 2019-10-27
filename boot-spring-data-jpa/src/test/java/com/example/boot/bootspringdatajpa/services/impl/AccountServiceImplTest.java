package com.example.boot.bootspringdatajpa.services.impl;

import com.example.boot.bootspringdatajpa.services.IAccountService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles(value = "unittest")
public class AccountServiceImplTest {

    @Autowired
    private IAccountService accountService;

    @Test
    public void testCreate() {
        Long accountId = accountService.createAccount("david");
        assertEquals(new Double(0), accountService.viewMoney(accountId));
    }

    @Test
    public void testSaveMoney() {
        Long accountId = accountService.createAccount("david");
        Double moneyIn1 = 50000d;
        Double money = accountService.saveMoney(accountId, moneyIn1);
        assertEquals(moneyIn1, money);
        Double moneyIn2 = 30000d;
        money = accountService.saveMoney(accountId, moneyIn2);
        assertEquals(new Double(moneyIn1 + moneyIn2), money);
    }

    @Test
    public void testTakeMoney() {
        Long accountId = accountService.createAccount("david");
        Double saveMoney = 50000d;
        accountService.saveMoney(accountId, saveMoney);
        Double takeMoney = 20000d;
        Double remainMoney = accountService.takeMoney(accountId, takeMoney);
        assertEquals(new Double(saveMoney - takeMoney), remainMoney);
        try {
            accountService.takeMoney(accountId, remainMoney + 1);
            Assert.fail("取钱超出");
        } catch (Exception e) {

        }
    }

    @Test
    public void testTransferMoney() {
        Long sourceAccountId = accountService.createAccount("david");
        Long targetAccountId = accountService.createAccount("tom");
        Double saveMoney = 50000d;
        accountService.saveMoney(sourceAccountId, saveMoney);
        Double transferMoney = 20000d;
        accountService.transferMoney(sourceAccountId, targetAccountId, transferMoney);
        assertEquals(transferMoney, accountService.viewMoney(targetAccountId));
        assertEquals(new Double(saveMoney - transferMoney), accountService.viewMoney(sourceAccountId));
    }



}
