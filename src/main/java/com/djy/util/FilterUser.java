package com.djy.util;

import com.djy.po.User;

import java.util.Iterator;
import java.util.List;

public  class  FilterUser {
    /**
     * 删除del_flag==1的对象
     * @param list
     */
    public static void delDel_flag_one(List list){
        Iterator<User> it = list.iterator();
        while(it.hasNext()){
            User user = it.next();
            if(user.getDel_flag()==1){
                it.remove();
            }
        }
    }
}
