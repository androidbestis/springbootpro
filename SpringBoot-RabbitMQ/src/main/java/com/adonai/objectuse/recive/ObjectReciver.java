package com.adonai.objectuse.recive;

import com.adonai.entity.User;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 消息接收者，对象支持Object
 */
@Component
@RabbitListener(queues = "obj")
public class ObjectReciver {

    @RabbitHandler
    public void process(User user){
        System.out.println("Receiver object : " + user);
    }

}
