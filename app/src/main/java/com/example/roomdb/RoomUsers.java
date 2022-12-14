package com.example.roomdb;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "roomusers")
public class RoomUsers {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String userName, userPassword, name, userHomeAddress, userWorkAddress;

    public RoomUsers(int id, String userName, String userPassword, String name, String userHomeAddress, String userWorkAddress) {
        this.id = id;
        this.userName = userName;
        this.userPassword = userPassword;
        this.name = name;
        this.userHomeAddress = userHomeAddress;
        this.userWorkAddress = userWorkAddress;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserHomeAddress() {
        return userHomeAddress;
    }

    public void setUserHomeAddress(String userHomeAddress) {
        this.userHomeAddress = userHomeAddress;
    }

    public String getUserWorkAddress() {
        return userWorkAddress;
    }

    public void setUserWorkAddress(String userWorkAddress) {
        this.userWorkAddress = userWorkAddress;
    }
}
