package com.example.SpringAngular.util;

public class LoginResponse {
         String msg;
        boolean status;


    public LoginResponse() {
    }

    public LoginResponse(String msg, boolean status) {
        this.msg = msg;
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "LoginResponse{" +
                "msg='" + msg + '\'' +
                ", status=" + status +
                '}';
    }
}
