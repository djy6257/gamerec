package com.djy.controller;

import com.djy.po.User;
import com.djy.service.UserService;
import com.djy.util.FilterUser;
import com.djy.util.JsonObject;
import com.djy.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.*;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 根据条件查询对应的用户信息，都为空则为所有
     * @return 用户表格.json
     */
    @RequestMapping("user/userAll")
    @ResponseBody
    public JsonObject queryUserAll(String del_flag,String username,String telephone) {
        Map<String,String> map = new HashMap<>();
        map.put("del_flag", del_flag);
        map.put("username", username);
        map.put("telephone",telephone);

        List<User> list = userService.queryUserAll(map);
        System.out.println(list);

        //创建返回值对象
        JsonObject object = new JsonObject();
        object.setCode(0);
        object.setMsg("ok");
        object.setCount((long) list.size());
        object.setData(list);
        return object;
    }

    /**
     * 提交新增用户信息
     * @param user 用户
     * @return 对象（@ResponseBody)
     */
    @RequestMapping("addUserSubmit")
    @ResponseBody
    public R addUserSubmit(User user){
        //添加自创建信息
        userService.addUser(user);
        return R.ok();
    }

    /**
     *提交被修改用户信息
     * @param user 用户
     * @return 对象（@ResponseBody)
     */
    @ResponseBody
    @RequestMapping("updateUserSubmit")
    public R updateUser(User user){
        userService.updateUser(user);
        return R.ok();
    }

    /**
     * 将莫个用户修改为待删除用户
     * @param ids 全部用户id
     * @return 对象（@ResponseBody)
     */
    @ResponseBody
    @RequestMapping("updateReadyDelUserSubmit")
    public R updateReadyDelUserSubmit(String ids){
        List list = Arrays.asList(ids.split(","));
        userService.updateReadyDelUser(list);
        return R.ok();
    }

    /**
     * 发送请求恢复数据
     * @param ids
     * @return
     */
    @ResponseBody
    @RequestMapping("recoverUserByIds")
    public R recoverUserByIds(String ids){
        List list = Arrays.asList(ids.split(","));
        userService.recoverUserByIds(list);
        return R.ok();
    }


    /**
     * 根据id彻底删除用户
     * @param ids
     * @return
     */
    @ResponseBody
    @RequestMapping("deleteUserByIds")
    public R deleteUserByIds(String ids){
        List list = Arrays.asList(ids.split(","));
        userService.deleteUserByIds(list);
        return R.ok();
    }


    /**
     * 页面渲染使用
     */
    @RequestMapping("userList")
    public String userIndex(){
        return "page/userList";
    };

    @RequestMapping("addUser")
    public String addUser(){
        return "page/addUser";
    }

    @RequestMapping("editUser")
    public String editUser(Integer id, Model model){
        User user = userService.queryUserByID(id);
        model.addAttribute("user", user);
        return "page/editUser";
    }

    @RequestMapping("readyDelUser")
    public String readyDelUser(){return "page/readyDelUser";}

}
