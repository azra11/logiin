package com.example.admin.loginmovie;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.loginmovie.Koneksi.BaseApp;
import com.example.admin.loginmovie.ModelLogin.GetAllUserResponse;
import com.example.admin.loginmovie.ModelLogin.LoginResponse;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegistrationAcrtivity extends AppCompatActivity implements RegisView {
    private EditText username,userpassword,useremail;
    private Button Regist;
    private TextView userLogin;
    RegisPresenter regisPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        username = (EditText)findViewById(R.id.et_uname);
        userpassword=(EditText)findViewById(R.id.et_upass);
        useremail=(EditText)findViewById(R.id.et_email);
        Regist=(Button)findViewById(R.id.b_regis);
        userLogin=(TextView)findViewById(R.id.tv_ulogin);

        Regist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    regisPresenter.create(username.getText().toString(),useremail.getText().toString(), userpassword.getText().toString());
            }
        });
        userLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegistrationAcrtivity.this,LoginActivity.class));
            }
        });

    }



    @Override
    public void onSucces(String regis) {
        startActivity(new Intent(RegistrationAcrtivity.this,LoginActivity.class));
    }

    @Override
    public void onError(String errorMessage) {
        Toast.makeText(this,"isi semua terlebih dahulu!",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFailure(String failureMessage) {
        Toast.makeText(this,failureMessage,Toast.LENGTH_SHORT).show();
    }
}
