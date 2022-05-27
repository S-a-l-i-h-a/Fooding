package com.example.fooding;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface UserDao {

    @Insert
    void registerUser (UserEntity userEntity);

    @Query("SELECT * FROM users WHERE username=(:username) AND password= (:password)")
    UserEntity login(String username, String password);
}
