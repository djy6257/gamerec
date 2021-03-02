package com.djy.controller;

import com.djy.service.GameService;
import com.djy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
public class IndexController {

    @Autowired
    private UserService userService;
    @Autowired
    private GameService gameService;

    @RequestMapping("index")
    public String index(){
        return "index";
    }

    @RequestMapping("/welcome")
    public String welcome(Model model){
        Map<String, Integer> map = new HashMap<>();
        Integer userCount = userService.queryCount();//总人数
        Integer gameReadyCheckCount = gameService.queryCount(1);//待审核
        Integer gamePassCheckCount = gameService.queryCount(0);//审核通过
        Integer gameCount = gameReadyCheckCount+gamePassCheckCount;//总游戏数
        map.put("userCount",userCount);
        map.put("gameCount",gameCount);
        map.put("gameReadyCheckCount",gameReadyCheckCount);
        map.put("gamePassCheckCount",gamePassCheckCount);
        model.addAttribute("map", map);
        return "page/welcome";
    }
}
