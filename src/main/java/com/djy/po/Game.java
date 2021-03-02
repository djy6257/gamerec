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
     * gamephoto
     * del_flag
     * check
     * creatTime
     * updateTime
     */

    private Long id;
    private String gamename;
    private String company;
    private String describe;
    private Integer score;
    private Integer hot;
    private String gamephoto;
    private Integer del_flag;
    private Integer check;
    private Date creatTime;
    private Date updateTime;
}
