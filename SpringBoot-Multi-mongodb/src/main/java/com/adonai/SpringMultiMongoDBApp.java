package com.adonai;

import com.adonai.config.property.MultipleMongoProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(MultipleMongoProperties.class)
@SpringBootApplication(exclude = MongoAutoConfiguration.class)
public class SpringMultiMongoDBApp {

    public static void main(String args[]){
        SpringApplication.run(SpringMultiMongoDBApp.class,args);
    }
}
