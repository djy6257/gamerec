package com.djy.controller;

import com.djy.po.Game;
import com.djy.service.GameService;
import com.djy.util.JsonObject;
import com.djy.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class GameController {

    @Autowired
    private GameService gameService;

    /**
     * 根据条件查询用户
     * @param del_flag
     * @return
     */
    @RequestMapping("game/gameAll")
    @ResponseBody
    public JsonObject queryGameAll(String del_flag,String gamename,String check){
        Map<String,String> map = new HashMap<>();
        map.put("del_flag", del_flag);
        map.put("gamename",gamename);
        map.put("check", check);
        List<Game> list = gameService.queryGameAll(map);
        JsonObject object = new JsonObject();
        object.setCode(0);
        object.setMsg("ok");
        object.setCount((long) list.size());
        object.setData(list);
        return object;
    }

    /**
     * 将游戏更改为待删除状态
     * @param ids
     * @return
     */
    @RequestMapping("updateReadyDelGameSubmit")
    @ResponseBody
    public R updateReadyDelGameSubmit(String ids){
        List list = Arrays.asList(ids.split(","));
        System.out.println("id="+list);
        gameService.updateReadyDelGameSubmit(list);
        return R.ok();
    }

    /**
     * 增加游戏
     * @param game
     * @return
     */
    @RequestMapping("addGameSubmit")
    @ResponseBody
    public R addGameSubmit(Game game){
        gameService.addGame(game);
        return R.ok();
    }

    /**
     * 修改用户信息
     * @param game
     * @return
     */
    @RequestMapping("editGameSubmit")
    @ResponseBody
    public R editGameSubmit(Game game){
        gameService.editGame(game);
        return R.ok();
    }

    /**
     * 根据id彻底删除游戏
     * @param ids
     * @return
     */
    @ResponseBody
    @RequestMapping("deleteGameByIds")
    public R deleteGameByIds(String ids){
        List list = Arrays.asList(ids.split(","));
        gameService.deleteGameByIds(list);
        return R.ok();
    }

    /**
     * 发送请求恢复删除数据
     * @param ids
     * @return
     */
    @ResponseBody
    @RequestMapping("recoverGameByIds")
    public R recoverGameByIds(String ids){
        List list = Arrays.asList(ids.split(","));
        gameService.recoverGameByIds(list);
        return R.ok();
    }

    /**
     * 通过审核
     * @param ids
     * @return
     */
    @ResponseBody
    @RequestMapping("checkPass")
    public R checkPass(String ids){
        List list = Arrays.asList(ids.split(","));
        gameService.checkPass(list);
        return R.ok();
    }



    /**
     * 渲染使用
     */
    @RequestMapping("gameList")
    public String gameList(){return "page/gameList";}

    @RequestMapping("addGame")
    public String addGame(){ return "page/addGame";}

    @RequestMapping("editGame")
    public String editUser(Integer id, Model model){
        Game game = gameService.queryGameByID(id);
        model.addAttribute("game", game);
        return "page/editGame";
    }

    @RequestMapping("readyDelGame")
    public String readyDelGame(){return "page/readyDelGame";}

    @RequestMapping("check")
    public String check(){return "page/check";}

}
