package com.adonai.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * 采用jpa技术来自动生成基础表格，对应的entity如下：
 * 权限信息
 *   关系:
      权限-----角色-----用户
 */
@Data
@Entity
public class SysPermission {

    @Id  @GeneratedValue
    private Integer id;          //主键.
    private String name;         //名称.
    @Column(columnDefinition = "enum('menu','button')")
    private String resourceType; //资源类型，[menu|button]
    private String url;          //资源路径.
    private String permission;   //权限字符串,menu例子：role:*，button例子：role:create,role:update,role:delete,role:view
    private Long parentId;       //父编号
    private String parentIds;    //父编号列表
    private Boolean available = Boolean.FALSE;

    @ManyToMany
    @JoinTable(name = "")
    private List<SysRole> roles;


}
