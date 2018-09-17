package com.adonai.topic;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Topic模式发送者
 * 使用queueMessages同时匹配两个队列，queueMessage只匹配”topic.message”队列
 * 发送send1会匹配到topic.#和topic.message 两个Receiver都可以收到消息，发送send2只有topic.#可以匹配所有只有Receiver2监听到消息
 */
@Component
public class TopicSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(){
        String context = "hi, i am message all";
        System.out.println("Sender : " + context);
        //消息发送
        this.rabbitTemplate.convertAndSend("topicExchange", "topic.1", context);
    }

    public void send1(){
        String context = "hi, i am message 1";
        System.out.println("Sender : " + context);
        this.rabbitTemplate.convertAndSend("topicExchange", "topic.message", context);
    }

    public void send2(){
        String context = "hi, i am messages 2";
        System.out.println("Sender : " + context);
        this.rabbitTemplate.convertAndSend("topicExchange", "topic.messages", context);
    }
}
