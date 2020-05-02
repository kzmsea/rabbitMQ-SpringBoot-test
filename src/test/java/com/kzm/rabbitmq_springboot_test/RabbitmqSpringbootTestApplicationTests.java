package com.kzm.rabbitmq_springboot_test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RabbitmqSpringbootTestApplicationTests {

    @Autowired
    private HelloSender helloSender;

    @Test
    void contextLoads() throws InterruptedException {
        for (int i=0;i<100;i++){
            helloSender.send(i);
            Thread.sleep(300);
        }
    }

}
