package com.kzm.rabbitmq_consumer.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RabbitListener(queues = "TestDirectQueue")
public class DirectReceiver {

    @RabbitHandler
    public void process(Map testMessage){
        System.out.println("消费者收到消息:"+testMessage);
    }

}
