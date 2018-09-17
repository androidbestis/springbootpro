package com.adonai.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * 接下来我们直接创建一个类继承 CommandLineRunner ，并实现它的 run() 方法。
 * CommandLineRunner 中的方法会在 Spring Boot 容器加载之后执行，执行完成后项目启动完成。
 *
 * 如果我们在启动容器的时候需要初始化很多资源，并且初始化资源相互之间有序，那如何保证不同的 CommandLineRunner 的执行顺序呢？Spring Boot 也给出了解决方案。
 * 那就是使用 @Order 注解。
 */
@Component
public class Runner implements CommandLineRunner{

    @Override
    public void run(String... strings) throws Exception {
        System.out.println("The Runner start to initialize ...");
    }
}
