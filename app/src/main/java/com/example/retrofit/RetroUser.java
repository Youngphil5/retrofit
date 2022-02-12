package com.example.retrofit;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.retrofit.db.retro_Database;

import java.util.ArrayList;
import java.util.HashMap;

@Entity(tableName = retro_Database.RETRO_TABLE)
public class RetroUser {
    @PrimaryKey(autoGenerate = true)// this helps when we insert an object into the database
    // it autogenerates a key for that object passed in.
    private  int mLogId;
    private String name;
    private String userName;
    private String password;
    private boolean isAdmin;



    public RetroUser(String name, String userName, String password) {
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.isAdmin = false;
    }



    public int getLogId() {
        return mLogId;
    }

    public void setLogId(int mLogId) {
        this.mLogId = mLogId;
    }

    public String getName() {
        return name;
    }

    public String getUserName() {
        return userName;
    }


    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\n" +
                "UserName: " + userName + "\n" +
                "Password: " + password + "\n"+
                "========================";
    }

}
