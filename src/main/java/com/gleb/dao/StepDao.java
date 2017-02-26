package com.gleb.dao;

import com.gleb.dao.object.DBStep;

import java.util.List;

/**
 * Created by gleb on 26.02.17.
 */
public interface StepDao {
    void save(DBStep dbStep);
    DBStep update(DBStep dbStep);
    List<DBStep> getByGameId(Integer id);
}
