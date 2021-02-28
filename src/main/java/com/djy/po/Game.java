package com.djy.po;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Game implements Serializable {

    /**
     * id
     * gamename
     * company
     * describe
     * score
     * hot
     * creat_time
     * update_time
     */

    private Long id;
    private String gamename;
    private String company;
    private String describe;
    private Integer score;
    private Integer hot;
    private Date creatTime;
    private Date updateTime;
}
