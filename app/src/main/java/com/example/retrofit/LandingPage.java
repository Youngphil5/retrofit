package com.example.retrofit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.retrofit.databinding.ActivityLandingPageBinding;
import com.example.retrofit.db.retroDAO;
import com.example.retrofit.db.retro_Database;

public class LandingPage extends AppCompatActivity {
    private ActivityLandingPageBinding binding;
    retroDAO retoDatabaseAcess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLandingPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(newIntent(LandingPage.this, "login"));

            }
        });

        binding.SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(newIntent(LandingPage.this, "Signup"));

            }
        });
    }

    @NonNull
    public static Intent newIntent(Context packageContext, String key){
        //this is the factory pattern
        Intent intent;

        if(key == "login"){
            intent = new Intent(packageContext, LoginActivity.class);
        }
        else{
            intent = new Intent(packageContext, SignUpActivity.class);
        }
        return intent;
    }
}