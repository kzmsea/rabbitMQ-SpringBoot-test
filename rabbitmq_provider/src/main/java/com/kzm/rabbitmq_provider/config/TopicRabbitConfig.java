package com.kzm.rabbitmq_provider.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TopicRabbitConfig {

    //绑定键
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
    public TopicExchange TestTopicExchange(){
        return new TopicExchange("topicExchange");
    }

    //将firstQueue队列与topicExchange绑定，而且绑定键值是topic.man
    @Bean
    public Binding bindingExchangeMessage(){
        return BindingBuilder.bind(firstQueue()).to(TestTopicExchange()).with(man);
    }

    //将secondQueue队列与topucExchange绑定，键值规则是topic.#
    //这样只要是以topic.开头的键值都会发送到secondQueue队列
    @Bean
    public Binding bindingExchangeMessage2(){
        return BindingBuilder.bind(secondQueue()).to(TestTopicExchange()).with("topic.#");
    }

}
