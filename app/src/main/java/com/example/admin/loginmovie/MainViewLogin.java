package com.example.admin.loginmovie;

import com.example.admin.loginmovie.ModelLogin.GetAllUserResponse;
import com.example.admin.loginmovie.ModelLogin.LoginResponse;

public interface MainViewLogin {
    void onError(String errorMessage);
    void onFailure(String failureMessage);
    void getSuccess(LoginResponse listItem);
}
