package com.adonai.controller;

import com.adonai.entity.User;
import com.adonai.entity.UserInfo;
import com.adonai.entity.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 如何在查找数据库的时候自动使用缓存呢?
 * 自动根据方法生成缓存
 */
@RestController
public class AutoGenreCacheController {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @RequestMapping("/getUser")
    @Cacheable(value = "user-key")
    public UserInfo getUser(){
        UserInfo userinfo= userInfoRepository.findByUserName("aa");
        System.out.println("若下面没出现“无缓存的时候调用”字样且能打印出数据表示测试成功");
        return userinfo;
    }

}
