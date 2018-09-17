package com.adonai.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * RabbitMQ配置
 * 队列配置
 */
@Configuration
public class RabbitConfig {

    //普通队列
    @Bean
    public Queue queue(){
       return  new Queue("Hello");
    }

    //多对多队列
    @Bean
    public Queue multimanyQueue(){
        return new Queue("multimany");
    }

    //支持Object对象队列
    @Bean
    public Queue objectQueue(){
        return new Queue("obj");
    }


}
