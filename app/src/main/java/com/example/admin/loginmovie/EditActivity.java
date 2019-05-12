package com.example.admin.loginmovie;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.admin.loginmovie.Koneksi.AddPreferences;
import com.example.admin.loginmovie.ModelLogin.GetUserResponse;
import com.example.admin.loginmovie.ModelLogin.UpdateUserResponse;

public class EditActivity extends AppCompatActivity implements UpdateView,GetUserView {
    EditText nama;
    Button simpan;
    UpdatePresenter updatePresenter;
    private AddPreferences addPreferences;
    GetUserPresenter getUserPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit);

        getUserPresenter = new GetUserPresenter(getApplicationContext(), this);
        addPreferences = new AddPreferences(getApplicationContext());
        getUserPresenter.ambil(addPreferences.getToken());

        nama = findViewById(R.id.et_e_nama);
        simpan = findViewById(R.id.b_e_save);

    }

        public void updateUser (View view){
            String username = nama.getText().toString();
            updatePresenter = new UpdatePresenter(getApplicationContext(), this);
            updatePresenter.update(addPreferences.getToken(), username);
        }


        @Override
        public void onSucces (UpdateUserResponse update){
            Toast.makeText(getApplicationContext(), "Updated!", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
        }

        @Override
        public void onSucces (GetUserResponse getuser){
            nama.setText(getuser.getName());

        }

        @Override
        public void onError (String errorMessage){
            Toast.makeText(getApplicationContext(), errorMessage, Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onFailure (String failureMessage){
            Toast.makeText(getApplicationContext(), failureMessage, Toast.LENGTH_SHORT).show();
        }

}