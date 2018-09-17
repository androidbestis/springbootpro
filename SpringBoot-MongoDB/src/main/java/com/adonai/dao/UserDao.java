package com.adonai.dao;

import com.adonai.entity.UserEntity;

public interface UserDao {

    //创建对象
    public void saveUser(UserEntity user);
    //根据用户名查询对象
    public UserEntity findUserByUserName(String userName);
    //更新对象
    public void updateUser(UserEntity user);
    //删除对象
    public void deleteUserById(Long id);
}
