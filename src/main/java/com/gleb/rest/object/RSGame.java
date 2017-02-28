package com.gleb.rest.object;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by ggerasim on 2/27/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RSGame {

    private Integer id;

    private String name;

    private String status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "{" +
                "\"id\":" + id +
                ", \"name\":'" + name + '\'' +
                ", \"status\":'" + status + '\'' +
                '}';
    }
}
