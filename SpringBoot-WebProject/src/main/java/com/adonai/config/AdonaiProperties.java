package com.adonai.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 自定义Property配置类
 */
@Component
@Data
public class AdonaiProperties {

  @Value("${com.adonai.title}")
  private String title;

  @Value("${com.adonai.description}")
  private String description;

}
