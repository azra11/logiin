package com.example.admin.loginmovie;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.loginmovie.Koneksi.AddPreferences;
import com.example.admin.loginmovie.ModelLogin.GetUserResponse;
import com.example.admin.loginmovie.ModelLogin.LoginResponse;
import com.example.admin.loginmovie.ModelLogin.UpdateUserResponse;


public class Akun_Fragment extends Fragment implements GetUserView, UpdateView {
    View view;
    private Button btnLogout, btnEdit;
    AddPreferences addPreferences;
    GetUserPresenter getUserPresenter;
    TextView tvuname,tvuemaail;
    Boolean savelogin;


    public Akun_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_profile, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnEdit = view.findViewById(R.id.b_p_Edit);
        tvuname = view.findViewById(R.id.tv_profilenama);
        tvuemaail = view.findViewById(R.id.tv_email);
        btnLogout = view.findViewById(R.id.b_p_logout);

        getUserPresenter = new GetUserPresenter(getContext(),this);
        addPreferences = new AddPreferences(getContext());
        getUserPresenter.ambil(addPreferences.getToken());

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ganti = new Intent(getActivity().getApplicationContext(), EditActivity.class);
                startActivity(ganti);
            }
        });

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addPreferences.logout(addPreferences.getToken());
                startActivity(new Intent(getContext(), LoginActivity.class));
            }
        });
    }

    @Override
    public void onSucces(GetUserResponse getUserResponse) {
        tvuname.setText(getUserResponse.getName());
        tvuemaail.setText(getUserResponse.getEmail());

    }

    @Override
    public void onSucces(UpdateUserResponse update) {
        Toast.makeText(getContext(),"Update",Toast.LENGTH_SHORT).show();
        tvuname.setText(update.getName());
    }

    @Override
    public void onError(String errorMessage) {
        Toast.makeText(getContext(),"Error"+errorMessage,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFailure(String failureMessage) {
        Toast.makeText(getContext(),"OnFailure" + failureMessage,Toast.LENGTH_SHORT).show();

    }
}

