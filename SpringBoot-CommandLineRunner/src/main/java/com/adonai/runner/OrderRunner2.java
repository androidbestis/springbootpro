package com.adonai.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 在启动容器的时候需要初始化很多资源，并且初始化资源相互之间有序，那如何保证不同的 CommandLineRunner 的执行顺序呢？Spring Boot 也给出了解决方案。
 * 那就是使用 @Order 注解。
 *
 * 通过控制台的输出我们发现，添加 @Order 注解的实现类最先执行，并且@Order()里面的值越小启动越早。
   在实践中，使用ApplicationRunner也可以达到相同的目的，两着差别不大。看来使用 Spring Boot 解决初始化资源的问题非常简单。
 */
@Component
@Order(2)
public class OrderRunner2 implements CommandLineRunner{

    @Override
    public void run(String... strings) throws Exception {
        System.out.println("The OrderRunner2 start to initialize ...");
    }
}
