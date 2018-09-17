package com.adonai.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Jpa数据库操作接口
 */
@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo,Long>{

    UserInfo findByUserName(String userName);
    UserInfo findByUserNameOrEmail(String userName, String email);
}
