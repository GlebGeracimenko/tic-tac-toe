package com.gleb.service;

import com.gleb.rest.object.RSGame;

import java.util.List;

/**
 * Created by gleb on 27.02.17.
 */
public interface GameService {
    RSGame save(RSGame rsGame);
    List<RSGame> getAllGames();
}
