package com.example.retrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.retrofit.db.retroDAO;
import com.example.retrofit.db.retro_Database;
import com.example.retrofit.models.BookSearchResultsAdapter;

public class LoginActivity extends AppCompatActivity {

    retroDAO retroDatabaseAccess;
    EditText username;
    EditText passwod;
    Button login;
    SharedPreferences preferences;
    SharedPreferences.Editor editPrefrences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        preferences = getSharedPreferences("lastLoginInfo", MODE_PRIVATE);
        editPrefrences = preferences.edit();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        retroDatabaseAccess = Room.databaseBuilder(this, retro_Database.class,retro_Database.DB_NAME)
                .allowMainThreadQueries()
                .build()
                .getRetroDAO();

        username = findViewById(R.id.LoginUsername);
        passwod = findViewById(R.id.LoginPassword);
        login = findViewById(R.id.loginButton);



        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RetroUser existingCustomer = retroDatabaseAccess.getRetroUserByUsername(
                        username.getText().toString());

                if(existingCustomer == null){
                    Toast.makeText(LoginActivity.this, "Invalid username or password",
                            Toast.LENGTH_SHORT).show();
                }
                else if(existingCustomer.getPassword().equals(passwod.getText().toString())){
                    editPrefrences.putString("username",existingCustomer.getUserName());
                    editPrefrences.apply();
                    Intent intent = new Intent(LoginActivity.this, MainActivity2.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(LoginActivity.this, "Invalid username or password",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}