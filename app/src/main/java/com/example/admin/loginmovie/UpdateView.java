package com.example.admin.loginmovie;

import com.example.admin.loginmovie.ModelLogin.UpdateUserResponse;

public interface UpdateView {
    void onSucces(UpdateUserResponse update);
    void onError(String errorMessage);
    void onFailure(String failureMessage);
}
