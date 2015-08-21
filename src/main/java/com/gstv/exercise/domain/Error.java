package com.gstv.exercise.domain;

/**
 * Created by davidhoak on 8/21/15.
 */
public class Error {

    private String message;

    public Error(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
