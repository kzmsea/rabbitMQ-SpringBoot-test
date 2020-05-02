package com.kzm.rabbitmq_consumer.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RabbitListener(queues = "topic.woman")
public class TopicWomanReceiver {

    @RabbitHandler
    public void process(Map testMessage){
        System.out.println("TestWomanReceiver消费者收到消息："+testMessage);
    }

}
