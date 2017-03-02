package com.gleb.dao.impl;

import com.gleb.dao.GameDao;
import com.gleb.dao.rowMapper.GameRowMapper;
import com.gleb.dao.object.DBGame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by gleb on 26.02.17.
 */
@Repository
public class GameDaoImpl implements GameDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public DBGame save(final DBGame dbGame) {
        KeyHolder holder = new GeneratedKeyHolder();
//        jdbcTemplate.update("INSERT INTO games (name, status) VALUE (?,?)", dbGame.getName(), dbGame.getStatus(), holder);
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {

                PreparedStatement ps = con.prepareStatement("INSERT INTO games (id, name, status) VALUE (DEFAULT,?,?)", new String[]{"id"});

                ps.setString(1, dbGame.getName());
                ps.setString(2, dbGame.getStatus());

                return ps;
            }
        }, holder);
        Integer id = holder.getKey().intValue();
        dbGame.setId(id);
        return dbGame;
    }

    @Override
    public DBGame update(DBGame dbGame) {
        if (dbGame == null || dbGame.getId() == null) {
            return null;
        }
        if (dbGame.getName() == null) {
            jdbcTemplate.update("UPDATE games SET  status=? WHERE id=?", dbGame.getStatus(), dbGame.getId());
        } else if (dbGame.getStatus() == null) {
            jdbcTemplate.update("UPDATE games SET name=? WHERE id=?", dbGame.getName(), dbGame.getId());
        } else {
            jdbcTemplate.update("UPDATE games SET name=?, status=? WHERE id=?", dbGame.getName(), dbGame.getStatus(), dbGame.getId());
        }
        return getById(dbGame.getId());
    }

    @Override
    public DBGame getById(Integer id) {
        List<DBGame> dbSteps = jdbcTemplate.query("SELECT * FROM games WHERE id=?", new Object[]{id}, new GameRowMapper());
        if (dbSteps.isEmpty()) {
            return null;
        }
        return dbSteps.get(0);
    }

    @Override
    public String getStatusById(Integer id) {
        String status = jdbcTemplate.queryForObject("SELECT status FROM games WHERE id=?", new Object[]{id}, String.class);
        return status;
    }

    @Override
    public List<DBGame> getAll() {
        return jdbcTemplate.query("SELECT * FROM games", new GameRowMapper());
    }
}
