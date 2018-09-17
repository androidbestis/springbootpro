package com.adonai.mapper.test2;

import com.adonai.entity.UserEntity;

import java.util.List;

/**
 * 数据源二mapper
 */
public interface User2Mapper {


    List<UserEntity> getAll();

    UserEntity getOne(Long id);

    void insert(UserEntity user);

    void update(UserEntity user);

    void delete(Long id);

}
