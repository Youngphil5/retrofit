package com.example.retrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.retrofit.databinding.ActivityLandingPageBinding;
import com.example.retrofit.databinding.ActivitySignUpBinding;
import com.example.retrofit.db.retroDAO;
import com.example.retrofit.db.retro_Database;

import java.util.List;

public class SignUpActivity extends AppCompatActivity {
    private  ActivitySignUpBinding binding;
    retroDAO retroDatabaseAcess;
    String log; //used to print out any issue while signing up
    List<RetroUser> retroUsers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        retroDatabaseAcess = Room.databaseBuilder(this, retro_Database.class,retro_Database.DB_NAME)
                .allowMainThreadQueries()
                .build()
                .getRetroDAO();
        retroUsers = retroDatabaseAcess.getRetoUsers();

        if(retroDatabaseAcess.getRetroUserByUsername("admin2") == null){
            addAdmin();
        }
        print();

        binding.Create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RetroUser newCustomer = getDetailsFromScreen();
                log = validateCustomer(newCustomer);

                if(log.equals("SUCCESS")){
                    Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                    retroDatabaseAcess.insert(newCustomer);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(SignUpActivity.this, log,Toast.LENGTH_SHORT).show();
                }
            }
        });



    }
    private RetroUser getDetailsFromScreen(){
        String customerName = binding.name.getText().toString();
        String username = binding.username.getText().toString();
        String password = binding.Password.getText().toString();

        RetroUser newCustomer = new RetroUser(
                customerName, username, password);

        return newCustomer;
    }

    private void print(){
        if(retroUsers.size() == 0){
            System.out.println("No customers");
        }
        else{
            for(RetroUser customer : retroUsers){
                System.out.println(customer.toString());
            }
        }
    }

    private void addAdmin(){
        RetroUser admin = new RetroUser("admin","admin2",
                "admin2");
        admin.setAdmin(true);
        retroDatabaseAcess.insert(admin);
    }

    String validateCustomer(RetroUser customer){//more validation will come in the future.
        String message = "SUCCESS";
        if(customer.getPassword().length() == 0
                && customer.getUserName().length() == 0 ){
            message = "Please Enter a username and a password";
        }
        return message;
    }


    }



