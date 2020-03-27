package com.example.boot.bootspringjdbc;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TmpTest {
    @Test
    public void test() throws ClassNotFoundException, SQLException {
        Thread.currentThread().setContextClassLoader(TmpTest.class.getClassLoader().getParent());
        Class cls = Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test");
        System.out.println(DriverManager.class.getClassLoader());
//        System.out.println(cls.getClassLoader());
    }
}
