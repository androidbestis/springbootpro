package com.adonai.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
* 第二个数据源配置,第二个库的封装
 * 配置不同包路径下使用不同的数据源
*/
@Configuration
@EnableMongoRepositories(
        basePackages = "com.adonai.model.repository.secondary",
        mongoTemplateRef = SecondaryMongoConfig.MONGO_TEMPLATE
)
public class SecondaryMongoConfig {

    protected static final String MONGO_TEMPLATE = "secondaryMongoTemplate";

}
