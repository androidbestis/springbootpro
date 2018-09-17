package com.adonai;

import com.adonai.simpleuse.sender.HelloSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 测试Hello Queue
 * 注意，发送者和接收者的queue name必须一致，不然不能接收
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMqHelloTest {

   @Autowired
   private HelloSender helloSender;

   @Test
   public void hello() throws Exception{
       helloSender.send();
   }
}
