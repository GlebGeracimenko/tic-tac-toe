package com.gleb.rest.object;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by ggerasim on 2/27/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RSStep {

    private Integer step;

    private Integer field;

    private Integer gameId;

    private String value;

    public Integer getStep() {
        return step;
    }

    public void setStep(Integer step) {
        this.step = step;
    }

    public Integer getField() {
        return field;
    }

    public void setField(Integer field) {
        this.field = field;
    }

    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "{" +
                "\"step\":" + step +
                ", \"field\":" + field +
                ", \"gameId\":" + gameId +
                ", \"value\":'" + value + '\'' +
                '}';
    }
}
