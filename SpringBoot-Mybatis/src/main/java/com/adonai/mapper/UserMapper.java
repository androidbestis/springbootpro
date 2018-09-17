package com.adonai.mapper;

import com.adonai.entity.UserEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 开发Mapper,sql生产都在这里
 */
public interface UserMapper {

    //@Select 是查询类的注解，所有的查询均使用这个
    //@Result 修饰返回的结果集，关联实体类属性和数据库字段一一对应，如果实体类属性和数据库属性名保持一致，就不需要这个属性来修饰。
    @Select("SELECT * FROM userinfo")
    @Results({
            @Result(property = "id",column ="id"),
            @Result(property = "email",column ="email"),
            @Result(property = "nick_name",column ="nick_name"),
            @Result(property = "pass_word",column ="pass_word"),
            @Result(property = "reg_time",column = "reg_time"),
            @Result(property = "user_name",column = "user_name")
    })
    List<UserEntity> getAll();


    @Select("SELECT * FROM userinfo WHERE id = #{id}")
    @Results({
            @Result(property = "id",column ="id"),
            @Result(property = "email",column ="email"),
            @Result(property = "nick_name",column ="nick_name"),
            @Result(property = "pass_word",column ="pass_word"),
            @Result(property = "reg_time",column = "reg_time"),
            @Result(property = "user_name",column = "user_name")
    })
     UserEntity getOne(Long id);

    //@Insert 插入数据库使用，直接传入实体类会自动解析属性到对应的值
    @Insert("INSERT INTO userinfo(id,email,nick_name,pass_word,reg_time,user_name) VALUES(#{id},#{email},#{nick_name},#{pass_word},#{reg_time},#{user_name})")
    void insert(UserEntity user);

    //@Update 负责修改，也可以直接传入对象
    @Update("UPDATE userinfo SET nick_name=#{nick_name},pass_word=#{pass_word} WHERE id = #{id}")
    void update(UserEntity user);

    //@delete 负责删除
    @Delete("DELETE FROM userinfo WHERE id = #{id}")
    void delete(Long id);

    //注意:
    /**
     * #{}，更加安全，能够防范SQL注入；prepared预编译SQL,动态传参,自动替换#里的值
       ${}，无法防范SQL注入，一般用于传入不需要转义的参数,原样输出$里面的值。
       MyBatis排序时使用Order By动态参数时需要注意，使用$而不是#。
     */
}
