package com.gleb.mapping;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gleb.dao.object.DBStep;
import com.gleb.rest.object.RSStep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ggerasim on 2/28/17.
 */
@Component
public class StepMapper {

    @Autowired
    private ObjectMapper mapper;

    public RSStep map(DBStep dbStep) {
        if (dbStep == null) return null;

        RSStep rsStep = mapper.convertValue(dbStep, RSStep.class);
        return rsStep;
    }

    public DBStep map(RSStep rsStep) {
        if (rsStep == null) return null;

        DBStep dbStep = mapper.convertValue(rsStep, DBStep.class);
        return dbStep;
    }

    public List<RSStep> map(List<DBStep> dbSteps) {
        if (dbSteps == null || dbSteps.isEmpty()) return new ArrayList<>();

        List<RSStep> rsSteps = new ArrayList<>();
        for (DBStep dbStep : dbSteps) {
            RSStep rsStep = map(dbStep);
            rsSteps.add(rsStep);
        }
        return rsSteps;
    }
}
