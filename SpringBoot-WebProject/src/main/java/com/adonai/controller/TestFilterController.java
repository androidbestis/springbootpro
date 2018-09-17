package com.adonai.controller;

import com.adonai.config.AdonaiProperties;
import com.adonai.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *测试Filter
 */
@RestController
public class TestFilterController {

    @Autowired
    private AdonaiProperties custom_properties;


    @RequestMapping("/getUser")
    public User getUser() {
        User user=new User();
        user.setUsername(custom_properties.getTitle());
        user.setPassword(custom_properties.getDescription());
        return user;
    }

}
