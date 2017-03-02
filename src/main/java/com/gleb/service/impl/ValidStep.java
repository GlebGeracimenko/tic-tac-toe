package com.gleb.service.impl;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;

/**
 * Created by ggerasim on 3/2/17.
 */
@Service
public class ValidStep {

    public Map<Integer, List<List<Integer>>> map;

    @PostConstruct
    public void init() {
        if (map == null) map = new LinkedHashMap<>();

        //for 1 field
        map.put(1, asList(asList(1, 2, 3),asList(1, 4, 7),asList(1, 5, 9)));

        //for 2 field
        map.put(2, asList(asList(1, 2, 3),asList(2, 5, 8)));

        //for 3 field
        map.put(3, asList(asList(1, 2, 3),asList(3, 6, 9),asList(3, 5, 7)));

        //for 4 field
        map.put(4, asList(asList(1, 4, 7),asList(4, 5, 6)));

        //for 5 field
        map.put(5, asList(asList(1, 5, 9),asList(3, 5, 7),asList(4, 5, 6),asList(2, 5, 8)));

        //for 6 field
        map.put(6, asList(asList(3, 6, 9),asList(4, 5, 6)));

        //for 7 field
        map.put(7, asList(asList(1, 4, 7),asList(3, 5, 7),asList(7, 8, 9)));

        //for 8 field
        map.put(8, asList(asList(2, 5, 8),asList(7, 8, 9)));

        //for 9 field
        map.put(9, asList(asList(1, 5, 9),asList(3, 6, 9),asList(7, 8, 9)));
    }

}
