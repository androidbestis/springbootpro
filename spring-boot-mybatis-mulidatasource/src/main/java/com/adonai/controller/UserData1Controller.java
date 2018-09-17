package com.adonai.controller;

import com.adonai.entity.UserEntity;
import com.adonai.mapper.test1.User1Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 测试数据源一
 */
@RestController
@RequestMapping("/data1")
public class UserData1Controller {

    @Autowired
    private User1Mapper user1Mapper;

    //查询数据源一全部数据
    @RequestMapping("/getUsers")
    public List<UserEntity> getUsers() {
        List<UserEntity> users=user1Mapper.getAll();
        return users;
    }

    //查询数据源一一条记录
    @RequestMapping("/getUser")
    public UserEntity getUser(Long id) {
        UserEntity user=user1Mapper.getOne(id);
        return user;
    }

    //往数据源一添加一条记录
    @RequestMapping("/add")
    public void save(UserEntity user) {
        user1Mapper.insert(user);
    }

    //更新数据源一记录
    @RequestMapping(value="update")
    public void update(UserEntity user) {
        user1Mapper.update(user);
    }

    //删除数据源一一条记录
    @RequestMapping(value="/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        user1Mapper.delete(id);
    }

}
