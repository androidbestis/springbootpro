package com.adonai.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 数据实体
 */
@Data
public class UserEntity implements Serializable{

    private static final long serialVersionUID = -3258839839160856613L;

    private Long id;
    private String userName;
    private String passWord;

}
