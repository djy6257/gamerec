package com.djy.service;

import com.djy.dao.GameDao;
import com.djy.po.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service("gameService")
public class GameServiceImpl implements GameService {

    @Autowired
    GameDao gameDao;

    /**
     * 根据条件查询内容
     * @param map
     * @return
     */
    @Override
    public List<Game> queryGameAll(Map map) {
        return gameDao.queryGameAll(map);
    }

    /**
     * 将游戏状态跟改为待删除状态
     * @param list
     */
    @Override
    public void updateReadyDelGameSubmit(List list) {
        gameDao.updateReadyDelGameSubmit(list);
    }

    /**
     * 增加游戏
     * @param game
     */
    @Override
    public void addGame(Game game) {
        game.setGamephoto("xxxx");
        game.setCreatTime(new Date());
        game.setUpdateTime(new Date());
        System.out.println(game);
        gameDao.addGame(game);
    }

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    @Override
    public Game queryGameByID(Integer id) {
        return gameDao.queryGameByID(id);
    }

    /**
     * 修改游戏信息
     * @param game
     */
    @Override
    public void editGame(Game game) {
        game.setUpdateTime(new Date());
        game.setGamephoto("XXXX");
        gameDao.editGame(game);
    }

    /**
     * 根据id彻底删除游戏
     * @param list
     */
    @Override
    public void deleteGameByIds(List list) {
        gameDao.deleteGameByIds(list);
    }

    /**
     * 恢复游戏数据
     * @param list
     */
    @Override
    public void recoverGameByIds(List list) {
        gameDao.recoverGameByIds(list);
    }

    /**
     * 通过审核
     * @param list
     */
    @Override
    public void checkPass(List list) {
        gameDao.checkPass(list);
    }

    /**
     * 查询未在删除状态下的游戏总数
     * @return
     */
    @Override
    public Integer queryCount(Integer check) {
        return gameDao.queryCount(check);
    }
}
