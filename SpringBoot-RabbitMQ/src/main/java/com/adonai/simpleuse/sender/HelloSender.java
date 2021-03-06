package com.adonai.simpleuse.sender;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 消息发送者
 * rabbitTemplate是springboot 提供的默认实现
 */
@Component
public class HelloSender {

   @Autowired
   private AmqpTemplate rabbitTemplate;

   public void send(){
       String context = "hello" + new Date();
       System.out.println("Sender : " + context);
       rabbitTemplate.convertAndSend("Hello",context);
   }

}
