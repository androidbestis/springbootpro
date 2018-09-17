package com.adonai.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.UUID;

/**
 * 测试Redis Session
 */
@RestController
public class TestRedisSessionController {

    @RequestMapping("/uid")
    public String uid(HttpSession session){
        UUID uid = (UUID)session.getAttribute("uid");
        if(uid == null){
            uid = UUID.randomUUID();
        }
        session.setAttribute("uid",uid);
        return session.getId();
    }

    /**
     *  登录redis 输入 keys '*sessions*'
            t<spring:session:sessions:db031986-8ecc-48d6-b471-b137a3ed6bc4
            t(spring:session:expirations:1472976480000
        其中 1472976480000为失效时间，意思是这个时间后session失效，db031986-8ecc-48d6-b471-b137a3ed6bc4 为sessionId,
        登录http://localhost:8080/uid 发现会一致，就说明session 已经在redis里面进行有效的管理了。
     */

    /**
     *   如何在两台或者多台中共享session
          其实就是按照上面的步骤在另一个项目中再次配置一次，启动后自动就进行了session共享。
     */
}
