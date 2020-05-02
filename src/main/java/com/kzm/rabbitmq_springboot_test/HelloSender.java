package com.kzm.rabbitmq_springboot_test;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class HelloSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(int i){
        String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        String context="hello,"+i+"——"+date;
        System.out.println("sender:"+context);

        this.rabbitTemplate.convertAndSend("q_hello",context);
    }

}
