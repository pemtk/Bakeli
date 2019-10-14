package com.volkeno.bakeliapi.model;

/**
 * Created by Prince Eros Michel TOLA KOGADOU on .
 */
public class LoginResponse {

    private boolean success;
    private String message;
    private BakeliModel data;

    public LoginResponse(boolean success, String message, BakeliModel data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public BakeliModel getData() {
        return data;
    }

    public void setData(BakeliModel data) {
        this.data = data;
    }
}
