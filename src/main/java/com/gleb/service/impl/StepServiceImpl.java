package com.gleb.service.impl;

import com.gleb.dao.StepDao;
import com.gleb.dao.object.DBStep;
import com.gleb.mapping.StepMapper;
import com.gleb.rest.object.RSStep;
import com.gleb.service.StepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ggerasim on 2/28/17.
 */
@Service
public class StepServiceImpl implements StepService {

    @Autowired
    private StepDao stepDao;

    @Autowired
    private StepMapper stepMapper;

    @Override
    public RSStep save(RSStep rsStep) {
        DBStep dbStep = stepMapper.map(rsStep);
        stepDao.save(dbStep);
        return stepMapper.map(dbStep);
    }

    @Override
    public List<RSStep> getByGameId(Integer id) {
        List<DBStep> steps = stepDao.getByGameId(id);
        return stepMapper.map(steps);
    }
}
