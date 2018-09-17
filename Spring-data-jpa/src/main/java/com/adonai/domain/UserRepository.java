package com.adonai.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 继承JpaRepository
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long> {

}
