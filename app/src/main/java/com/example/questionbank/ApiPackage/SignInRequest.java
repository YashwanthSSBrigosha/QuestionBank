package com.example.questionbank.ApiPackage;

public class SignInRequest {
    String email,password;
    Boolean isWebLogin;

    public SignInRequest(String email, String password, Boolean isWebLogin) {
        this.email = email;
        this.password = password;
        this.isWebLogin = isWebLogin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getWebLogin() {
        return isWebLogin;
    }

    public void setWebLogin(Boolean webLogin) {
        isWebLogin = webLogin;
    }
}
