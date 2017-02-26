package com.gleb.dao.mapper;

import com.gleb.dao.object.DBGame;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by gleb on 26.02.17.
 */
public class GameRowMapper implements RowMapper<DBGame> {
    @Override
    public DBGame mapRow(ResultSet rs, int rowNum) throws SQLException {
        DBGame game = new DBGame();
        game.setId(rs.getInt("id"));
        game.setName(rs.getString("name"));
        game.setStatus(rs.getString("status"));
        return game;
    }
}
