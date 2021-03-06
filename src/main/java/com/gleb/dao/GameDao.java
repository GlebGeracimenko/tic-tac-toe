package com.gleb.dao;

import com.gleb.dao.object.DBGame;

import java.util.List;

/**
 * Created by gleb on 26.02.17.
 */
public interface GameDao {
    DBGame save(DBGame dbGame);

    DBGame update(DBGame dbGame);

    DBGame getById(Integer id);

    String getStatusById(Integer id);

    List<DBGame> getAll();
}
