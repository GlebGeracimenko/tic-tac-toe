package com.gleb.dao.rowMapper;

import com.gleb.dao.object.DBStep;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by gleb on 26.02.17.
 */
public class StepRowMapper implements RowMapper<DBStep> {
    @Override
    public DBStep mapRow(ResultSet rs, int rowNum) throws SQLException {
        DBStep step = new DBStep();
        step.setField(rs.getInt("field"));
        step.setStep(rs.getInt("step"));
        step.setGameId(rs.getInt("game_id"));
        return step;
    }
}
