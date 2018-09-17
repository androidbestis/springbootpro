package com.adonai.mapper.test1;

import com.adonai.entity.UserEntity;
import java.util.List;

/**
 * 数据源一mapper
 */
public interface User1Mapper {

    List<UserEntity> getAll();

    UserEntity getOne(Long id);

    void insert(UserEntity user);

    void update(UserEntity user);

    void delete(Long id);

}
