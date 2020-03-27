package com.example.bootwithdocker;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogTest {

    @Test
    public void test() {
        Logger logger = LoggerFactory.getLogger(LogTest.class);
        logger.info("hello");
    }

}
