package com.example.admin.loginmovie;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.loginmovie.Koneksi.AddPreferences;
import com.example.admin.loginmovie.LoginPresenter;
import com.example.admin.loginmovie.MainViewLogin;
import com.example.admin.loginmovie.ModelLogin.GetAllUserResponse;
import com.example.admin.loginmovie.ModelLogin.LoginResponse;
import com.example.admin.loginmovie.R;
import com.example.admin.loginmovie.RegistrationAcrtivity;
import com.example.admin.loginmovie.Tabactivity;

public class LoginActivity extends AppCompatActivity implements MainViewLogin {
    private AddPreferences preferenceconfig;
    private EditText Username, UserPassword;
    private LoginPresenter loginPresenter;
    private TextView daftar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        preferenceconfig = new AddPreferences(getApplicationContext());
        Username = findViewById(R.id.et_user);
        UserPassword = findViewById(R.id.et_pass);
        daftar = findViewById(R.id.tv_register);
        daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),RegistrationAcrtivity.class));
            }
        });

        if (preferenceconfig.readLoginStatus()) {
            startActivity(new Intent(this, Tabactivity.class));
            finish();
        }
    }

    public void loginUser(View view) {
        String username = Username.getText().toString();
        String userpassword = UserPassword.getText().toString();
        loginPresenter = new LoginPresenter((MainViewLogin) getApplicationContext());
        loginPresenter.login(username,userpassword);
    }



    @Override
    public void getSuccess(LoginResponse login) {
        preferenceconfig.token(login.getToken());
        startActivity(new Intent(getApplicationContext(),Tabactivity.class));
    }

    @Override
    public void onError(String errorMessage) {
        Toast.makeText(getApplicationContext(),"gAGAL",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFailure(String failureMessage) {
        Toast.makeText(getApplicationContext(),"Gagal",Toast.LENGTH_SHORT).show();
    }

}