package com.adonai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * Spring Boot 如何解决项目启动时初始化资源
 * 在我们实际工作中，总会遇到这样需求，在项目启动的时候需要做一些初始化的操作，比如初始化线程池，提前加载好加密证书等。
 * 今天就给大家介绍一个 Spring Boot 神器，专门帮助大家解决项目启动初始化资源操作。
   这个神器就是 CommandLineRunner，CommandLineRunner 接口的 Component 会在所有 Spring Beans 都初始化之后，SpringApplication.run() 之前执行，
   非常适合在应用程序启动之初进行一些数据初始化的工作。
 */
@SpringBootApplication
public class CommandLineRunnerApplication {

    /**
     * 接下来我们就运用案例测试它如何使用，在测试之前在启动类加两行打印提示，方便我们识别 CommandLineRunner 的执行时机。
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("The service to start.");
        SpringApplication.run(CommandLineRunnerApplication.class, args);
        System.out.println("The service has started.");
    }

}
