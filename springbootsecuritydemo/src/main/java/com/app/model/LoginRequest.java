package com.app.model;

import lombok.Data;

@Data
public class LoginRequest {

    private String userName;
    private String password;

    public void setUserName(String userName) {
        this.userName = userName;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}
