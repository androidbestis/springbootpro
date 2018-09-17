package com.adonai;

import com.adonai.fanout.FanoutSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Fanout消息测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMqFanoutTest {

    @Autowired
    private FanoutSender fanoutSender;

    @Test
    public void fanoutSender() throws Exception {
        fanoutSender.send();
    }

}
