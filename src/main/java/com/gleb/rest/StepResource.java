package com.gleb.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gleb.dao.StepDao;
import com.gleb.dao.object.DBStep;
import com.gleb.rest.object.RSStep;
import com.gleb.service.StepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


/**
 * Created by ggerasim on 2/27/17.
 */
@RestController
@RequestMapping(path = "/step")
public class StepResource {

    @Autowired
    private StepService stepService;

    @RequestMapping(method = RequestMethod.POST, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> nextStep(@RequestBody RSStep rsStep) {
        RSStep response = stepService.save(rsStep);
        if (response.getStep() % 2 == 1) {
            response.setValue("X");
        } else {
            response.setValue("O");
        }
        return ResponseEntity.ok(response);
    }
}
