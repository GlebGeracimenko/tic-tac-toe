package com.gleb.service.impl;

import com.gleb.dao.GameDao;
import com.gleb.dao.object.DBGame;
import com.gleb.mapping.GameMapper;
import com.gleb.rest.object.RSGame;
import com.gleb.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.gleb.dao.object.Status.IN_PRODRESS;

/**
 * Created by gleb on 27.02.17.
 */
@Service
public class GameServiceImpl implements GameService {

    @Autowired
    private GameDao gameDao;

    @Autowired
    private GameMapper mapper;

    @Override
    public RSGame save(RSGame rsGame) {
        DBGame game = mapper.map(rsGame);
        if (game.getStatus() == null) {
            game.setStatus(IN_PRODRESS.getValue());
        }
        gameDao.save(game);
        return mapper.map(game);
    }

    @Override
    public List<RSGame> getAllGames() {
        List<DBGame> dbGames = gameDao.getAll();
        return mapper.map(dbGames);
    }
}
