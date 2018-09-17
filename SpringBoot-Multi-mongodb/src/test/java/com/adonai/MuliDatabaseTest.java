package com.adonai;

import com.adonai.model.repository.primary.PrimaryMongoObject;
import com.adonai.model.repository.primary.PrimaryRepository;
import com.adonai.model.repository.secondary.SecondaryMongoObject;
import com.adonai.model.repository.secondary.SecondaryRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * 测试MongoDB多数据源
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MuliDatabaseTest {

    //数据源一
    @Autowired
    private PrimaryRepository primaryRepository;

    //数据源二
    @Autowired
    private SecondaryRepository secondaryRepository;


    @Test
    public void TestSave() throws Exception{
        System.out.println("************************************************************");
        System.out.println("测试开始");
        System.out.println("************************************************************");

        this.primaryRepository.save(new PrimaryMongoObject(null, "第一个库的对象"));

        this.secondaryRepository.save(new SecondaryMongoObject(null, "第二个库的对象"));

        List<PrimaryMongoObject> primaries = this.primaryRepository.findAll();
        for (PrimaryMongoObject primary : primaries) {
            System.out.println(primary.toString());
        }

        List<SecondaryMongoObject> secondaries = this.secondaryRepository.findAll();
        for (SecondaryMongoObject secondary : secondaries) {
            System.out.println(secondary.toString());
        }

        System.out.println("************************************************************");
        System.out.println("测试完成");
        System.out.println("************************************************************");
    }
}
