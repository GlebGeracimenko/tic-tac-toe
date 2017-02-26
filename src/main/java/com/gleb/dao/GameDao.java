package com.gleb.dao;

import com.gleb.dao.object.DBGame;

import java.util.List;

/**
 * Created by gleb on 26.02.17.
 */
public interface GameDao {
    DBGame save(DBGame dbGame);
    DBGame update(DBGame dbGame);
    List<DBGame> getById(Integer id);
}
