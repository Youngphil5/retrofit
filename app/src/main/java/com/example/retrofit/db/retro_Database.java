package com.example.retrofit.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.retrofit.RetroUser;

@Database(entities = {RetroUser.class}, version = 1)
//tell database what is going to be stored in the database
// when we change the structure of our database we have to increment the version number.

public abstract class retro_Database extends RoomDatabase {
    public static final String DB_NAME = "Retro_Database";
    public static final String RETRO_TABLE = "Retro_Table";

    public abstract retroDAO getRetroDAO(); //(This is the dataBase
    // we can implement it here but we will let the interpreter
    //handel it for us. //used to get info from database
}
