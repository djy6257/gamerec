package com.djy.service;

import com.djy.po.User;

import java.util.List;
import java.util.Map;

public interface UserService {

    /**
     * 根据条件查询对应用户信息
     * @return 用户信息
     */
    List<User> queryUserAll(Map map);

    /**
     * 添加用户信息
     * @param user
     */
    void addUser(User user);

    /**
     * 根据id查找用户
     * @param id
     * @return
     */
    User queryUserByID(Integer id);


    /**
     * 修改用户
     * @param user
     */
    void updateUser(User user);


    /**
     * 将莫个或者多个用户修改为待删除用户
     * @param ids
     */
    void updateReadyDelUser(List<Integer> ids);

    /**
     * 根据id彻底删除用户
     * @param ids
     */
    void deleteUserByIds(List<Integer> ids);

    /**
     * 恢复用户数据
     * @param list
     */
    void recoverUserByIds(List list);

    /**
     * 封禁用户
     * @param list
     */
    void blockedUserById(List list);
}
