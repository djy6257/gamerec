package com.djy.dao;

import com.djy.po.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component("userDao")
public interface UserDao {


    /**
     * 查询所有符合要求的用户信息
     * @param map
     * @return
     */
    List<User> queryUserAll(Map map);

    /**
     *添加新用户
     * @param user
     */
    void addUser(User user);

    /**
     * 根据id查询用户信息
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
     * 发送请求恢复数据
     * @param list
     */
    void recoverUserByIds(List list);
}
