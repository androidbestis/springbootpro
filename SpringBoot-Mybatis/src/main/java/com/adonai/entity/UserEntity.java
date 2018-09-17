package com.adonai.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity implements Serializable{

    private Integer id;
    private String email;
    private String nick_name;
    private String pass_word;
    private String reg_time;
    private String user_name;

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", nick_name='" + nick_name + '\'' +
                ", pass_word='" + pass_word + '\'' +
                ", reg_time='" + reg_time + '\'' +
                ", user_name='" + user_name + '\'' +
                '}';
    }
}
