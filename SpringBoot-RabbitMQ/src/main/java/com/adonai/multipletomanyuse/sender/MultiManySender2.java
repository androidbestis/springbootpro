package com.adonai.multipletomanyuse.sender;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 多对多消息发送者，消息发送者2
 */
@Component
public class MultiManySender2 {

   @Autowired
   private AmqpTemplate rabbitmq;

   public void send(int i){
       String context = "spirng boot multiple many queue"+" ****** "+i;
       System.out.println("Sender2 : " + context);
       rabbitmq.convertAndSend("multimany",context);
   }
}
