package com.gleb.counter;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by gleb on 26.02.17.
 */
@Component
@Scope(scopeName = "session")
public class StepCount {

    private Integer count;

    @PostConstruct
    public void init() {

    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
