package com.adonai;

import com.adonai.domain.ComplexQueryRepository;
import com.adonai.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 测试复杂查询
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestComplexQuery {

    @Autowired
    private ComplexQueryRepository complexQueryRepository;


    @Test
    public void testPageQuery() throws Exception{
        int page = 1;
        int size = 2;
        Sort sort = new Sort(Sort.Direction.DESC,"id");
        PageRequest pageable = new PageRequest(page, size, sort);
        Page<User> all = complexQueryRepository.findAll(pageable);
        for (User user:all) {
            System.out.println("分页查询所有数据: " + user.toString());
        }

        //根据name查询并分页
        Page<User> Bynamepageable = complexQueryRepository.findByName("wdn", pageable);
        for (User user:Bynamepageable) {
            System.out.println("根据name查询并分页数据: " + user.toString());
        }
    }

}
