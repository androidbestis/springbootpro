package com.adonai;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.adonai.mapper")    //扫描omapper映射文件,或者直接在Mapper类上面添加注解@Mapper,建议使用这种，不然每个mapper加个注解也挺麻烦的
public class SpringBootMybatisApplication {

  public static void main(String args[]){
      SpringApplication.run(SpringBootMybatisApplication.class,args);
  }

}
