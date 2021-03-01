package com.djy.service;

import com.djy.dao.UserDao;
import com.djy.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    /**
     * 查询所有用户
     * @return
     */
    @Override
    public List<User> queryUserAll(Map map) {
        return userDao.queryUserAll(map);
    }

    /**
     * 添加用户
     * @param user
     */
    @Override
    public void addUser(User user) {
        user.setHead("xxxx");
        user.setCreatTime(new Date());
        user.setUpdateTime(new Date());
        userDao.addUser(user);
    }

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    @Override
    public User queryUserByID(Integer id) {
        return userDao.queryUserByID(id);
    }

    /**
     * 修改用户信息
     * @param user
     */
    @Override
    public void updateUser(User user) {
        user.setHead("xxxx");
        user.setUpdateTime(new Date());
        userDao.updateUser(user);
    }

    /**
     * 将莫个用户修改为待删除用户
     */
    @Override
    public void updateReadyDelUser(List<Integer> ids) {
        userDao.updateReadyDelUser(ids);
    }

    /**
     * 根据id彻底删除用户
     * @param ids
     */
    @Override
    public void deleteUserByIds(List<Integer> ids) {
        userDao.deleteUserByIds(ids);
    }

    /**
     * 发送请求恢复数据
     * @param list
     */
    @Override
    public void recoverUserByIds(List list) {
        userDao.recoverUserByIds(list);
    }

    /**
     * 封禁用户
     * @param list
     */
    @Override
    public void blockedUserById(List list) {
        userDao.blockedUserById(list);
    }

    /**
     * 解除用户封禁
     * @param list
     */
    @Override
    public void recoverBlockedUserById(List list) {
        userDao.recoverBlockedUserById(list);
    }
}
