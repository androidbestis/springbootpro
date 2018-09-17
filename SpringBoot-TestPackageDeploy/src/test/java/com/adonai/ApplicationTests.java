package com.adonai;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    /**
     * 实际使用中，可以按照项目的正常使用去注入dao层代码或者是service层代码进行测试验证。
     * spring-boot-starter-test提供很多基础用法，更难得的是增加了对Controller层测试的支持--MockMvc。
     */
    @Test
    public void hello() throws Exception{
        System.out.println("hello world");
    }


    /**
     * 测试Assert断言
     * @throws Exception
     */
    @Test
    public void testAssert() throws Exception{
        int status = 200;
        //简单验证结果集是否正确
        Assert.assertEquals(3,3);

        //验证结果集，提示
        Assert.assertTrue("错误，正确的返回值为200", status == 200);
        Assert.assertFalse("错误，正确的返回值为200", status != 200);
    }

}
