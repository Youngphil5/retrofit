package com.example.retrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    SharedPreferences preferences;
    SharedPreferences.Editor editPrefrences;
    TextView loggedInUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        preferences = getSharedPreferences("lastLoginInfo", MODE_PRIVATE);
        editPrefrences = preferences.edit();



        Bundle args = new Bundle();
        args.putString("TeamName", preferences.getString("username",""));



        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

    }
}