package com.gleb.dao.object;

/**
 * Created by gleb on 26.02.17.
 * `step` int(2) NOT NULL,
 `field` int(2) NOT NULL,
 `game_id` int(
 */
public class DBStep {

    private Integer step;

    private Integer field;

    private Integer gameId;

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
}
