package com.kzm.rabbitmq_consumer.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DirectRabbitConfig {

    //声明队列
    @Bean
    public Queue TestDirectQueue(){
        return new Queue("TestDirectQueue",true);
    }

    //声明交换机
    @Bean
    public DirectExchange TestDirectExchange(){
        return new DirectExchange("TestDirectExchange");
    }

    //把队列绑定到交换机,并设置key
    @Bean
    public Binding bindingDirect(){
        return BindingBuilder.bind(TestDirectQueue()).to(TestDirectExchange()).with("TestDirectRouting");
    }

}
