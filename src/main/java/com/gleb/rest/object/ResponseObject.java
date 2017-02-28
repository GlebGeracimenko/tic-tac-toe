package com.gleb.rest.object;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by ggerasim on 2/28/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseObject<T> {

    private T response;

    public ResponseObject(T response) {
        this.response = response;
    }

    public T getResponse() {
        return response;
    }

    public void setResponse(T response) {
        this.response = response;
    }
}
