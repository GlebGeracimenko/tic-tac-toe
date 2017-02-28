package com.gleb.dao.impl;

import com.gleb.dao.StepDao;
import com.gleb.dao.rowMapper.StepRowMapper;
import com.gleb.dao.object.DBStep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by gleb on 26.02.17.
 */
@Repository
public class StepDaoImpl implements StepDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void save(DBStep dbStep) {
        int count = getCountStep(dbStep.getGameId());
        count++;
        jdbcTemplate.update("INSERT INTO steps (field, step, game_id) VALUE (?,?,?)", dbStep.getField(),
                count, dbStep.getGameId());
        dbStep.setStep(count);
    }

    @Override
    public DBStep update(DBStep dbStep) {
        return null;
    }

    @Override
    public List<DBStep> getByGameId(Integer id) {
        List<DBStep> dbSteps = jdbcTemplate.query("SELECT * FROM steps WHERE game_id=?", new Object[]{id}, new StepRowMapper());
        return dbSteps;
    }

    private int getCountStep(Integer id) {
        Integer count = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM steps WHERE game_id=" + id, Integer.class);
        return count.intValue();
    }
}
