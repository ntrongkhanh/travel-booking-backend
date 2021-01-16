package com.example.demo.exception;

public class BaseResponse {
    private String error;

    public BaseResponse() {
    }

    public BaseResponse(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
