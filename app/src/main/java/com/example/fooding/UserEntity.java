package com.example.fooding;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity (tableName = "users")
public class UserEntity {
    
    @PrimaryKey(autoGenerate = true)
    Integer id;

    @ColumnInfo(name = "username")
    String username;

    @ColumnInfo(name = "password")
    String password;

    @ColumnInfo(name = "email")
    String email;

    @ColumnInfo(name = "diet")
    String diet;

    @ColumnInfo(name = "diabetes")
    String diabetes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiet() {
        return diet;
    }

    public void setDiet(String diet) {
        this.diet = diet;
    }

    public String getDiabetes() {
        return diabetes;
    }

    public void setDiabetes(String diabetes) {
        this.diabetes = diabetes;
    }
}
