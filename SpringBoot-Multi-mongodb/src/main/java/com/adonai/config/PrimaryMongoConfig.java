package com.adonai.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * 第一个数据源配置,第一个库的封装
 * 配置不同包路径下使用不同的数据源
 */
@Configuration
@EnableMongoRepositories(basePackages = "com.adonai.model.repository.primary",
        mongoTemplateRef = PrimaryMongoConfig.MONGO_TEMPLATE
)
public class PrimaryMongoConfig {

    protected  static final String MONGO_TEMPLATE = "primaryMongoTemplate";

}
