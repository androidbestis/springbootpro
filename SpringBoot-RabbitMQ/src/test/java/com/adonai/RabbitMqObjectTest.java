package com.adonai;

import com.adonai.entity.User;
import com.adonai.objectuse.sender.ObjectSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 测试对象消息 obj Queue
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMqObjectTest {

    @Autowired
    private ObjectSender objectSender;

    @Test
    public void sendOject() throws  Exception{
        User user = new User();
        user.setName("lxd");
        user.setPass("123456");
        objectSender.send(user);
    }
}
