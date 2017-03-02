package com.gleb.service.impl;

import com.gleb.dao.StepDao;
import com.gleb.dao.object.DBStep;
import com.gleb.dao.object.Status;
import com.gleb.mapping.StepMapper;
import com.gleb.rest.object.RSStep;
import com.gleb.service.GameService;
import com.gleb.service.StepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by ggerasim on 2/28/17.
 */
@Service
public class StepServiceImpl implements StepService {
    private static final String X_WON = "XXX";
    private static final String O_WON = "OOO";

    @Autowired
    private StepDao stepDao;

    @Autowired
    private StepMapper stepMapper;

    @Autowired
    private ValidStep validStep;

    @Override
    public RSStep save(RSStep rsStep) {
        DBStep dbStep = stepMapper.map(rsStep);
        stepDao.save(dbStep);
        RSStep response = stepMapper.map(dbStep);
        Status status = chackGameResult(rsStep.getGameId());
        if (status != null) {
            response.setStatus(status.getValue());
        }
        return response;
    }

    @Override
    public List<RSStep> getByGameId(Integer id) {
        List<DBStep> steps = stepDao.getByGameId(id);
        return stepMapper.map(steps);
    }

    private Status chackGameResult(Integer id) {
        List<RSStep> rsSteps = getByGameId(id);
        Map<Integer, RSStep> mapSteps = toMap(rsSteps);
        for (Integer field : mapSteps.keySet()) {
            List<List<Integer>> list = validStep.map.get(field);
            for (List<Integer> list1 : list) {
                StringBuilder values = new StringBuilder();
                for (Integer key : list1) {
                    RSStep step = mapSteps.get(key);
                    if (step == null) {
                        break;
                    }
                    if (step.getStep() % 2 == 1) {
                        values.append("X");
                    } else {
                        values.append("O");
                    }
                }
                if (values.toString().equals(X_WON)) {
                    return Status.X_WON;
                } else if (values.toString().equals(O_WON)) {
                    return Status.O_WON;
                }
            }
        }
        if (rsSteps.size() == 9) {
            return Status.DRAW;
        }
        return null;
    }

    private Map<Integer, RSStep> toMap(List<RSStep> rsSteps) {
        Map<Integer, RSStep> map = new LinkedHashMap<>();
        for (RSStep step : rsSteps) {
            map.put(step.getField(), step);
        }
        return map;
    }

}
