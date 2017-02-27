package com.gleb.rest;

import com.gleb.rest.object.RSGame;
import com.gleb.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * Created by ggerasim on 2/27/17.
 */
@RestController
@RequestMapping(path = "/game")
public class GameResource {

    @Autowired
    private GameService gameService;

    @RequestMapping(method = RequestMethod.POST, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> saveGame(@RequestBody @NotNull RSGame rsGame) {
        RSGame response = gameService.save(rsGame);
        return ResponseEntity.ok(response);
    }


}