package com.example.admin.loginmovie;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TableLayout;

public class Tabactivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemReselectedListener {
    private Button logout;
    Fragment fragment;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);
        bottomNavigationView=findViewById(R.id.bnv);
        loadFragment(new HomeFragment());
        bottomNavigationView.setOnNavigationItemSelectedListener((BottomNavigationView.OnNavigationItemSelectedListener) this);

    }
    private boolean loadFragment(Fragment fragment){
        if (fragment != null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fi, fragment).commit();
            return true;
        }
        return false;

    }
    @Override
    public void onNavigationItemReselected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.logoutmenu : {
            }
            case R.id.m_profile: {
                startActivity(new Intent(Tabactivity.this,Akun_Fragment.class));
            }
        }
    }
}
