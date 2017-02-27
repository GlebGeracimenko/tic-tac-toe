package com.gleb.dao.impl;

import com.gleb.dao.GameDao;
import com.gleb.dao.mapper.GameRowMapper;
import com.gleb.dao.object.DBGame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by gleb on 26.02.17.
 */
@Repository
public class GameDaoImpl implements GameDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public DBGame save(DBGame dbGame) {
        KeyHolder holder = new GeneratedKeyHolder();
        jdbcTemplate.update("INSERT INTO games (name, status) VALUE (?,?)", dbGame.getName(), dbGame.getStatus(), holder);
        Integer id = holder.getKey().intValue();
        dbGame.setId(id);
        return dbGame;
    }

    @Override
    public DBGame update(DBGame dbGame) {
        jdbcTemplate.update("UPDATE games SET name=?, status=? WHERE id=?", dbGame.getName(), dbGame.getStatus(), dbGame.getId());
        return dbGame;
    }

    @Override
    public List<DBGame> getById(Integer id) {
        List<DBGame> dbSteps = jdbcTemplate.query("SELECT * FROM steps WHERE game_id=", new Object[]{id}, new GameRowMapper());
        return dbSteps;
    }
}
