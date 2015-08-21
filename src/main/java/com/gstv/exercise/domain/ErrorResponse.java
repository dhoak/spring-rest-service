package com.gstv.exercise.domain;

/**
 * Created by davidhoak on 8/21/15.
 */
public class ErrorResponse extends BaseResponse {

    private String message;

    public ErrorResponse(String message) {
        this.message = message;
        setStatus("error");
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
