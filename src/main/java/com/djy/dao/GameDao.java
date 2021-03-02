package com.djy.dao;

import com.djy.po.Game;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component("gameDao")
public interface GameDao {

    /**
     * 根据条件查询相应的游戏
     * @param map
     * @return
     */
    List<Game> queryGameAll(Map map);

    /**
     * 将游戏状态跟改为待删除状态
     * @param list
     */
    void updateReadyDelGameSubmit(List list);

    /**
     * 增加游戏
     * @param game
     */
    void addGame(Game game);

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    Game queryGameByID(Integer id);

    /**
     * 修改游戏信息
     * @param game
     */
    void editGame(Game game);

    /**
     * 根据id彻底删除游戏
     * @param list
     */
    void deleteGameByIds(List list);

    /**
     * 恢复游戏数据
     * @param list
     */
    void recoverGameByIds(List list);

    /**
     * 通过审核
     * @param list
     */
    void checkPass(List list);
}
