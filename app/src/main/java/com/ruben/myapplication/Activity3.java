package com.ruben.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Activity3 extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_success);
        Toast.makeText(getApplicationContext(), "Login Correcto!", Toast.LENGTH_SHORT).show();
    }

    public void doExit(View view) {
        setContentView(R.layout.activity_main);
    }
}
