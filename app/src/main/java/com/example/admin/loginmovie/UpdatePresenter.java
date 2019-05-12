package com.example.admin.loginmovie;

import android.content.Context;

import com.example.admin.loginmovie.Koneksi.BaseApp;
import com.example.admin.loginmovie.ModelLogin.UpdateUserResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UpdatePresenter {
    private Context context;
    private UpdateView updateView;

    public UpdatePresenter(Context context, UpdateView updateView) {
        this.context = context;
        this.updateView = updateView;
    }

    public void update(String token ,String name){
        BaseApp.service.updateUser(token,name).enqueue(new Callback<UpdateUserResponse>() {
            @Override
            public void onResponse(Call<UpdateUserResponse> call, Response<UpdateUserResponse> response) {
                if (response.isSuccessful()) {
                    updateView.onSucces(response.body());
                } else {
                    updateView.onError(response.message());
                }
            }

            @Override
            public void onFailure(Call<UpdateUserResponse> call, Throwable t) {
                updateView.onFailure(t.getMessage());
            }
        });

    }
}