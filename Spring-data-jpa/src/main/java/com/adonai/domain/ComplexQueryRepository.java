package com.adonai.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

/**
 * 复杂查询
 * 在实际的开发中我们需要用到分页、筛选、连表等查询的时候就需要特殊的方法或者自定义SQL
 */
public interface ComplexQueryRepository extends JpaRepository<User,Long>{

    //1.分页查询
    Page<User> findAll(Pageable pageable);
    Page<User> findByName(String name,Pageable pageable);

    //2.TODO 限制查询-----UnTest
    //有时候我们只需要查询前N个元素，或者只取前一个实体。
    User findFirstByOrderByLastnameAsc();
    User findTopByOrderByAgeDesc();
    Page<User> queryFirst10ByLastname(String lastname, Pageable pageable);
    List<User> findFirst10ByLastname(String lastname, Sort sort);
    List<User> findTop10ByLastname(String lastname, Pageable pageable);

    //3. TODO 自定义SQL查询-----UnTest
    @Modifying
    @Query("update User u set u.name = ?1 where u.id = ?2")
    int modifyByIdAndName(String name,Long id);

    @Transactional    //事务
    @Modifying
    @Query("delete from User where id = ?1")
    void deleteById(Long id);

    @Transactional
    @Query("select u from User u where u.name = ?1")
    User findByName(String name);

    //4.多表查询

}
