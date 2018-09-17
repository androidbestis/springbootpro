package com.adonai;

import com.adonai.entity.UserEntity;
import com.adonai.mapper.UsersMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sun.reflect.annotation.ExceptionProxy;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UsersMapper usersMapper;


    @Test
    public void testGetAll() throws Exception{
        List<UserEntity> all = usersMapper.getAll();
        for (UserEntity user: all) {
            System.out.println("查询的全部数据: " + user.toString());
        }
    }

    @Test
    public void testGetOne() throws Exception{
        UserEntity one = usersMapper.getOne(19L);
        System.out.println("查询一条记录: " + one.toString());
    }

    @Test
    public void testInsert() throws Exception{
        usersMapper.insert(new UserEntity(30,"sfsdfsdf6@163.com","独dsf","123$%^&","2018-9-11 3:34:23","ddfgd"));
    }

    @Test
    public void testDelete() throws Exception{
        usersMapper.delete(20L);
    }

    @Test
    public void testUpdate() throws Exception{
        UserEntity user = new UserEntity();
        user.setUser_name("李旭东");
        user.setNick_name("小影记忆");
        user.setId(1);
        usersMapper.update(user);
    }

}
