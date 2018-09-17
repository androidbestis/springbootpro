package com.adonai.controller;

import com.adonai.entity.UserEntity;
import com.adonai.mapper.test1.User1Mapper;
import com.adonai.mapper.test2.User2Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 测试数据源二
 */
@RestController
@RequestMapping("/data2")
public class UserData2Controller {


    @Autowired
    private User2Mapper user2Mapper;

    //查询数据源二全部数据
    @RequestMapping("/getUsers")
    public List<UserEntity> getUsers() {
        List<UserEntity> users=user2Mapper.getAll();
        return users;
    }

    //查询数据源二一条记录
    @RequestMapping("/getUser")
    public UserEntity getUser(Long id) {
        UserEntity user=user2Mapper.getOne(id);
        return user;
    }

    //往数据源二添加一条记录
    @RequestMapping("/add")
    public void save(UserEntity user) {
        user2Mapper.insert(user);
    }

    //更新数据源二记录
    @RequestMapping(value="update")
    public void update(UserEntity user) {
        user2Mapper.update(user);
    }

    //删除数据源二一条记录
    @RequestMapping(value="/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        user2Mapper.delete(id);
    }

}
