package com.gleb.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gleb.dao.StepDao;
import com.gleb.dao.object.DBStep;
import com.gleb.rest.object.RSStep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


/**
 * Created by ggerasim on 2/27/17.
 */
@RestController
@RequestMapping(path = "/step")
public class StepResource {

    @Autowired
    private StepDao stepDao;

    @RequestMapping(method = RequestMethod.POST, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> nextStep(@RequestBody RSStep rsStep) {
        ObjectMapper mapper = new ObjectMapper();
        DBStep dbStep = mapper.convertValue(rsStep, DBStep.class);
        stepDao.save(dbStep);
        if (dbStep.getStep() % 2 == 1) {
            return ResponseEntity.ok("X");
        } else {
            return ResponseEntity.ok("O");
        }
//        System.out.println("Value = " + rsStep.getValue());
    }

}
