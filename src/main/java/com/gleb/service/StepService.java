package com.gleb.service;

import com.gleb.rest.object.RSStep;

import java.util.List;

/**
 * Created by ggerasim on 2/28/17.
 */
public interface StepService {

    RSStep save(RSStep rsStep);

    List<RSStep> getByGameId(Integer id);
}
