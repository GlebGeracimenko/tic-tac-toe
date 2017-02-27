package com.gleb.dao.object;

/**
 * Created by gleb on 27.02.17.
 */
public enum Status {
    IN_PRODRESS("In progress"), X_WON("X won"), O_WON("O won"), DRAW("Draw");

    String value;

    Status(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
