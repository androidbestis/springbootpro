package com.adonai.repository;

import com.adonai.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 继承JpaRepository类会自动实现很多内置的方法，包括增删改查。也可以根据方法名来自动生成相关sql
 */
public interface UserRepository extends JpaRepository<User,Long>{

    User findById(long id);
    void deleteById(Long id);
}
