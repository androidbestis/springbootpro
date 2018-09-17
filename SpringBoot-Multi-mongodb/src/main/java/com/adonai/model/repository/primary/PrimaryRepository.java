package com.adonai.model.repository.primary;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * 数据源一的Repository
 * 继承了 MongoRepository 会默认实现很多基本的增删改查，省了很多自己写dao层的代码
 */
public interface PrimaryRepository extends MongoRepository<PrimaryMongoObject,String>{

}
