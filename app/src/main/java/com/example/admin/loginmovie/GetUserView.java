package com.example.admin.loginmovie;

import com.example.admin.loginmovie.ModelLogin.GetUserResponse;

public interface GetUserView {
    void onSucces(GetUserResponse loginResponse);
    void onError(String errorMessage);
    void onFailure(String failureMessage);
}

