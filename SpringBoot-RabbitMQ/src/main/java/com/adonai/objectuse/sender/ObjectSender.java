package com.adonai.objectuse.sender;

import com.adonai.entity.User;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 消息发送者，对象支持Object
 * rabbitTemplate是springboot 提供的默认实现
 */
@Component
public class ObjectSender {

      @Autowired
      private AmqpTemplate rabbitTemplate;

      public void send(User user){
          System.out.println("Sender object: " + user.toString());
          rabbitTemplate.convertAndSend("obj",user);
      }

}
