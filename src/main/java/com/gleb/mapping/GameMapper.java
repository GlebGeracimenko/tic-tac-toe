package com.gleb.mapping;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gleb.dao.object.DBGame;
import com.gleb.rest.object.RSGame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gleb on 27.02.17.
 */
@Component
public class GameMapper {

    @Autowired
    private ObjectMapper mapper;

    public RSGame map(DBGame dbGame) {
        if (dbGame == null) return null;
        RSGame rsGame = mapper.convertValue(dbGame, RSGame.class);
        return rsGame;
    }

    public DBGame map(RSGame rsGame) {
        if (rsGame == null) return null;
        DBGame dbGame = mapper.convertValue(rsGame, DBGame.class);
        return dbGame;
    }

    public List<RSGame> map(List<DBGame> dbGames) {
        if (dbGames == null || dbGames.isEmpty()) return new ArrayList<>();

        List<RSGame> rsGames = new ArrayList<>();
        for (DBGame dbGame : dbGames) {
            RSGame rsGame = map(dbGame);
            rsGames.add(rsGame);
        }
        return rsGames;
    }
}
