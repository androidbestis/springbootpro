package com.adonai.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * 采用jpa技术来自动生成基础表格，对应的entity如下：
 * 角色信息
 *  关系:
     权限-----角色-----用户
 */
@Entity
@Data
public class SysRole {

    @Id
    @GeneratedValue
    private Integer id;                             // 编号
    private String role;                            // 角色标识程序中判断使用,如"admin",这个是唯一的:
    private String description;                     // 角色描述,UI界面显示使用
    private Boolean available = Boolean.FALSE;      // 是否可用,如果不可用将不会添加给用户

    //角色 -- 权限关系：多对多关系;
    private List<SysPermission> permissions;

    // 用户 - 角色关系定义,多对多关系;
    private List<UserInfo> userInfos;// 一个角色对应多个用户



}
