package com.adonai;

import com.adonai.entity.UserEntity;
import com.adonai.mapper.UserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * 测试UserMapper
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

  @Autowired
  private UserMapper userMapper;

  @Test
  public void testInsert() throws Exception{
      userMapper.insert(new UserEntity(1,"1231316@163.com","独家记忆","123$%^&","2018-9-11 3:34:23","lxd"));
      userMapper.insert(new UserEntity(5,"sdfsd73423@163.com","day day up","sdfs4&","2012-4-21 13:26:43","java"));
      userMapper.insert(new UserEntity(16,"546j4hj3534@163.com","alibaba","345jj","2015-2-15 15:56:3","alibb"));

    Assert.assertEquals("5",userMapper.getAll().size()+"");
  }

  @Test
  public void testQuery() throws Exception{
      List<UserEntity> all = userMapper.getAll();
      for (UserEntity user: all) {
          System.out.println("查询全部数据:  "+user.toString());
      }
  }


  @Test
  public void testUpdate() throws Exception{
      UserEntity user = userMapper.getOne(5L);
      System.out.println("getOne查询一条数据: "+user.toString());
      user.setNick_name("good good study");
      userMapper.update(user);
      Assert.assertTrue("独家记忆".equals(userMapper.getOne(1L).getNick_name()));
  }

}
