package com.example.admin.loginmovie;

import android.widget.Toast;

import com.example.admin.loginmovie.Koneksi.BaseApp;
import com.example.admin.loginmovie.ModelLogin.LoginResponse;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginPresenter {
    private MainViewLogin mainViewLogin;

    public LoginPresenter(MainViewLogin mainViewLogin) {
        this.mainViewLogin = mainViewLogin;
    }

    public void login(String email, String password) {
        BaseApp.service.Login(email, password).enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response2) {
                if (response2.isSuccessful())
                    mainViewLogin.getSuccess(response2.body());
                else
                    mainViewLogin.onError(response2.message());
            }
            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                mainViewLogin.onFailure(t.getMessage());
            }
        });
    }


}
