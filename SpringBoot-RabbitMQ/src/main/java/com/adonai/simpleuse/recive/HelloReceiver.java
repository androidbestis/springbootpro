package com.adonai.simpleuse.recive;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 消息接收者
 */
@Component
@RabbitListener(queues = "Hello")
public class HelloReceiver {

    @RabbitHandler
    public void process(String Hello){
        System.out.println("Receiver  : " + Hello);
    }
}
