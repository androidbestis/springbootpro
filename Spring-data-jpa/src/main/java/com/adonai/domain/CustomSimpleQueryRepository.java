package com.adonai.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 自定义简单查询
 * 自定义的简单查询就是根据方法名来自动生成SQL，主要的语法是findXXBy,readAXXBy,queryXXBy,countXXBy, getXXBy后面跟属性名称：
 */
public interface CustomSimpleQueryRepository extends JpaRepository<User,Long>{

    //自定义根据name查询
   User findByName(String name);

   //自定义根据name和address查询,也使用一些加一些关键字And、 Or
   User findByNameOrAddress(String name,String address);

   //修改、删除、统计也是类似语法
   void deleteById(Long id);
   Long countByName(String name);

   //基本上SQL体系中的关键词都可以使用，例如：LIKE、 IgnoreCase、 OrderBy。
   List<User> findByNameLike(String name);
   User  findByNameIgnoreCase(String name);
   List<User> findByNameOrderByAge(String name);

}
