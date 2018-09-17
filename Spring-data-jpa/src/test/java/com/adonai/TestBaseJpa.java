package com.adonai;

import com.adonai.domain.User;
import com.adonai.domain.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

/**
 * 测试Jpa默认方法crud
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestBaseJpa {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testBaseQuery() throws Exception{
        User user = new User();
        //1.查询全部数据findAll
        List<User> all = userRepository.findAll();
        for (User u : all) {
            System.out.println("查询全部数据: " + u.toString());
        }

        //2.查询一条记录findOne
        User one_user = userRepository.findById(1L).get();
        System.out.println("查询一条记录: " + one_user);

        //3.插入一条记录save
        User save_user = userRepository.save(new User("fff", 26, "unkown", "miusic"));
        System.out.println("插入的数据: " + save_user.toString());

        //4.删除一条记录delete
        user.setId(21L);
        userRepository.delete(user);

        //5.查询记录的总数、数量
        long count = userRepository.count();
        System.out.println("数据总数:  " + count);

        //6.查询记录是否存在
        boolean exists = userRepository.existsById(2L);
        System.out.println("查询记录是否存在:  " + exists);
    }

}
