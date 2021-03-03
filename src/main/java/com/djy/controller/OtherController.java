package com.djy.controller;

import com.djy.po.Game;
import com.djy.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class OtherController {

    @Autowired
    private GameService gameService;



    @RequestMapping("rank")
    public String rank(Model model){
        Map<String,String> map = new HashMap<>();
        map.put("del_flag", "0");
        map.put("rank", "0");
        List<Game> gameList = gameService.queryGameAll(map);
        model.addAttribute("gamelist", gameList);
        return "page/rank";
    }

}
