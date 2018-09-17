package com.adonai;

import com.adonai.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.TimeUnit;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestRedis {

  @Autowired
  private StringRedisTemplate stringRedisTemplate;

  @Autowired
  private RedisTemplate redisTemplate;

  //测试String值
  @Test
  public void test() throws Exception{
       stringRedisTemplate.opsForValue().set("aaa","111");
       Assert.assertEquals("111",stringRedisTemplate.opsForValue().get("aaa"));
  }


  //测试对象Obj
  @Test
  public void testObj() throws Exception{
    User user=new User("aa@126.com", "12", "adonai", "aa","hangzhou");
    ValueOperations<String,User>  operations = redisTemplate.opsForValue();
    operations.set("com.adonai",user);
    operations.set("com.adonai.x",user,1, TimeUnit.SECONDS);    //该值在redis中只存在1秒
    Thread.sleep(1000);
    Boolean exists = redisTemplate.hasKey("com.adonai.x");      //1秒过后该值为空null
    if(exists){
        System.out.println("exists is true");
    }else{
        System.out.println("exists is false");
    }
      Assert.assertEquals("aa", operations.get("com.adonai.x").getPassword());
  }

}
