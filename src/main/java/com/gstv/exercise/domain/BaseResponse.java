package com.gstv.exercise.domain;

/**
 * Created by davidhoak on 8/20/15.
 */
public class BaseResponse {

    private String status = "success";

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
