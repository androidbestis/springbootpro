package com.adonai;

import com.adonai.multipletomanyuse.sender.MultiManySender1;
import com.adonai.multipletomanyuse.sender.MultiManySender2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 多对多消息使用测试
 * 注意，发送者和接收者的queue name必须一致，不然不能接收
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMqMultiManyTest {

    //发送者1
    @Autowired
    private MultiManySender1 multiManySender1;

    //发送者2
    @Autowired
    private MultiManySender2 multiManySender2;

    /**
     * 一对多发送
     * 根据返回结果得到以下结论:
         一个发送者，N个接受者,经过测试会均匀的将消息发送到N个接收者中
     */
    @Test
    public void oneToMany() throws Exception{
        for (int i=0;i<100;i++){
            multiManySender1.send(i);
        }
    }

    /**
     * 多对多发送
     * 结论：和一对多一样，接收端仍然会均匀接收到消息
     */
    @Test
    public void manyToMany() throws Exception{
        for (int i=0;i<100;i++){
            multiManySender1.send(i);
            multiManySender2.send(i);
        }
    }
}
