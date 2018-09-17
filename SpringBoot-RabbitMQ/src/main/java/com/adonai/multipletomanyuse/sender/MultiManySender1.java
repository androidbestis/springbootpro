package com.adonai.multipletomanyuse.sender;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 多对多消息发送者，消息发送者1
 */
@Component
public class MultiManySender1 {

   @Autowired
   private AmqpTemplate rabbitmqTemplate;

   public void send(int i){
      String context = "spirng boot multiple many queue"+" ****** "+ i;
      System.out.println("Sender1 : " + context);
      rabbitmqTemplate.convertAndSend("multimany",context);
   }
}
