package com.example.springsecurity.action;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class LoginBo {

    @NotBlank
    @Size(min = 0,max = 20,message = "用户名太长")
    private String username;
    @NotBlank
    @Size(min = 3,message = "密码太短，6~12位")
    private String password;

    @Override
    public String toString() {
        return "LoginBo{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}