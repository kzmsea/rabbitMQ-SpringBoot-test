package com.kzm.rabbitmq_consumer.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TopicRabbitConfig {

    public final static String man="topic.man";
    public final static String woman="topic.woman";

    @Bean
    public Queue firstQueue(){
        return new Queue(man);
    }

    @Bean
    public Queue secondQueue(){
        return new Queue(woman);
    }

    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange("topicExchange");
    }

    @Bean
    public Binding bindingExchangeMessage(){
        return BindingBuilder.bind(firstQueue()).to(topicExchange()).with(man);
    }

    @Bean
    public Binding bindingExchangeMessage2(){
        return BindingBuilder.bind(secondQueue()).to(topicExchange()).with("topic.#");
    }
}
