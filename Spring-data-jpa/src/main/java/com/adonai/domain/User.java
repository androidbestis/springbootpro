package com.adonai.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "user")     //对应要生成的表名
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

   private static final long serialVersionUID = 1L;

   @Id
   @GeneratedValue
   private Long id;
   @Column(nullable = false)
   private String name;
   @Column(nullable = false)
   private Integer age;
   @Column(nullable = false)
   private String address;
   @Column(nullable = true)
   private String hobby;


   public User(String name, Integer age, String address, String hobby) {
      this.name = name;
      this.age = age;
      this.address = address;
      this.hobby = hobby;
   }

   @Override
   public String toString() {
      return "User{" +
              "id=" + id +
              ", name='" + name + '\'' +
              ", age=" + age +
              ", address='" + address + '\'' +
              ", hobby='" + hobby + '\'' +
              '}';
   }
}
