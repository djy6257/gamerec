package com.djy.po;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class User implements Serializable {

    /**
     * id
     * username
     * password
     * telephone
     * email
     * QQ
     * wechat
     * head
     * del_flag
     * updateTime
     * creatTime
     */

    private Long id;
    private String username;
    private String password;
    private String telephone;
    private String email;
    private String qq;
    private String wechat;
    private String head;
    private Integer grade;
    private Integer del_flag;
    private Date creatTime;
    private Date updateTime;
}
