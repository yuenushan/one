package com.example.boot.bootspringdatajpa.repository;

import com.example.boot.bootspringdatajpa.domain.CustomerDomain;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles(value = "unittest")
public class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void testSave() {
        CustomerDomain customerDoamin = new CustomerDomain("david", "chen");
        customerRepository.save(customerDoamin);
        Assert.assertEquals(Long.valueOf(1), customerDoamin.getId());
    }

    @Test
    public void testFindById() {
        testSave();
        Assert.assertNotNull(customerRepository.findById(1));
    }

}
