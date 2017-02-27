package com.gleb.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gleb.dao.GameDao;
import com.gleb.dao.object.DBGame;
import com.gleb.rest.object.RSGame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * Created by ggerasim on 2/27/17.
 */
@RestController
@RequestMapping(path = "/game")
public class GameResource {

    @Autowired
    private GameDao gameDao;

    @RequestMapping(method = RequestMethod.POST, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> saveGame(@RequestBody RSGame rsGame) {
        ObjectMapper mapper = new ObjectMapper();
        DBGame dbGame = mapper.convertValue(rsGame, DBGame.class);
        DBGame dbGame1 = gameDao.save(dbGame);
        RSGame response = mapper.convertValue(dbGame1, RSGame.class);
        return ResponseEntity.ok(response);
    }


}