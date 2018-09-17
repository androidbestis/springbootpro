package com.adonai;

import com.adonai.entity.UserInfo;
import com.adonai.entity.UserInfoRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.DateFormat;
import java.util.Date;

/**
 * 测试jpa
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserInfoRepositoryTests {

   @Autowired
   private UserInfoRepository userInfoRepository;

   @Test
   public void test() throws Exception{
      Date date = new Date();
      DateFormat dateFormat  = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
      String formattedDate  = dateFormat.format(date);

      userInfoRepository.save(new UserInfo("aa1", "aa@126.com", "aa", "aa123456",formattedDate));
      userInfoRepository.save(new UserInfo("bb2", "bb@126.com", "bb", "bb123456",formattedDate));
      userInfoRepository.save(new UserInfo("cc3", "cc@126.com", "cc", "cc123456",formattedDate));

      //断言数据库数据总数
      Assert.assertEquals(3,userInfoRepository.findAll().size());
      Assert.assertEquals("bb123456",userInfoRepository.findByUserNameOrEmail("bb2", "cc@126.com").getNickName());
      userInfoRepository.delete(userInfoRepository.findByUserName("aa1"));
   }
}
