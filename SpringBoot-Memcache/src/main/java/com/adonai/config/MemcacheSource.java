package com.adonai.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
//@ConfigurationProperties(prefix = "memcache") 的意思会以 memcache.* 为开通将对应的配置文件加载到属性中。
@ConfigurationProperties(prefix = "memcache")
public class MemcacheSource {

    private String ip;
    private int port;

}
