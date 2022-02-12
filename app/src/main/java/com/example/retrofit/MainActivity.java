package com.example.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);
        startActivity(newIntent(MainActivity.this));
    }

    public static Intent newIntent(Context packageContext){
        //this is the factory pattern
        Intent intent = new Intent(packageContext, LandingPage.class);
        return intent;
    }


}