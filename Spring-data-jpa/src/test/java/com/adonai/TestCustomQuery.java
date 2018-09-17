package com.adonai;

import com.adonai.domain.CustomSimpleQueryRepository;
import com.adonai.domain.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * 测试自定义简单查询
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestCustomQuery {

    @Autowired
    private CustomSimpleQueryRepository customSimpleQueryRepository;

    @Test
    public void testCustomQuery() throws Exception{
        //1.自定义findByName
        User user = customSimpleQueryRepository.findByName("fff");
        System.out.println("根据name查询: " + user.toString());
        Assert.assertEquals("run",user.getHobby());

        //2.自定义findByNameOrAddress
        User orUser = customSimpleQueryRepository.findByNameOrAddress("", "zjhz");
        System.out.println("根据name或者address查询: " + orUser.toString());
        Assert.assertEquals("22",orUser.getAge().toString());

        //3.自定义countByName
        Long countUser = customSimpleQueryRepository.countByName("wdn");
        System.out.println("根据name查询总数据: " + countUser.toString());
        Assert.assertEquals("2",countUser.toString());

        //4.自定义findByNameLike
        List<User> likeUser = customSimpleQueryRepository.findByNameLike("%"+"f"+"%");
        for (User u:likeUser) {
            System.out.println("根据Name迷糊查询: " + u.toString());
        }

        //5.自定义findByNameIgnoreCase
        User ignoreUser = customSimpleQueryRepository.findByNameIgnoreCase("ffWdsFFS");
        System.out.println("根据name查询忽略大小写数据: " + ignoreUser.toString());
        Assert.assertEquals("walk",ignoreUser.getHobby());

        //6.自定义findByNameOrderByAge
        List<User> orderByUser = customSimpleQueryRepository.findByNameOrderByAge("wdn");
        for (User orderuser:orderByUser) {
            System.out.println("根据Name查询并且根据age排序: " + orderuser.toString());
        }

    }
}
