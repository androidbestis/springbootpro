package com.adonai.multipletomanyuse.recive;


import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 多对多消息接收者，消息接收者2
 */
@Component
@RabbitListener(queues = "multimany")
public class MultiManyReceiver2 {

    @RabbitHandler
    public void process(String multimany){
        System.out.println("Receiver 2: " + multimany);
    }

}
