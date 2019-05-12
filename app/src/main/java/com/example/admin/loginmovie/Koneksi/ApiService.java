package com.example.admin.loginmovie.Koneksi;

import com.example.admin.loginmovie.ModelLogin.GetUserResponse;
import com.example.admin.loginmovie.ModelLogin.LoginResponse;
import com.example.admin.loginmovie.ModelLogin.UpdateUserResponse;

import org.json.JSONObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ApiService {
    @FormUrlEncoded
    @POST ("/users/login") //dapet dari postman, hrs punya postman
    Call<LoginResponse> Login (@Field("email") String email,
                                              @Field("password") String passw);

    @FormUrlEncoded
    @POST("/users")
    Call<Void> Create (@Field("email") String email,
                           @Field("password") String passw,
                           @Field("name") String name);

    @GET("/users/")
    Call<List<GetUserResponse>> getUser (@Header("x-access-token")String token);

    @PUT("/users/")
    Call<UpdateUserResponse> updateUser (@Header("x-access-token") String token,
                                     @Field("name") String name);
}
