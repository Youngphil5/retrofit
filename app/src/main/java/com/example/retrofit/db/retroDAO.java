package com.example.retrofit.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.retrofit.RetroUser;

import java.util.List;
@Dao//this lets the interpreter know that this interface will be a data access object.
public interface retroDAO {
    @Insert
// allows us to add values to our database
    void insert(RetroUser... retroUsers);// the ... means that you can accept multiple aguments

    @Update
    void update(RetroUser... retroUsers);

    @Delete
    void delete(RetroUser... retroUsers);

    @Query("SELECT * FROM " + retro_Database.RETRO_TABLE + " ORDER BY  name DESC")//allows us to select everything from our gymlog tabel
    List<RetroUser> getRetoUsers(); // returns a list of all RetroUser objects from our table

    @Query("SELECT * FROM " + retro_Database.RETRO_TABLE + " WHERE mLogId = :logId")
    RetroUser getRetroUserById(int logId);

    @Query("SELECT * FROM " + retro_Database.RETRO_TABLE + " WHERE userName = :username")
    RetroUser getRetroUserByUsername(String username);
}
