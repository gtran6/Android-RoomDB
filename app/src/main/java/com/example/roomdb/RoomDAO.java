package com.example.roomdb;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface RoomDAO {
    @Insert
    void insert(RoomUsers roomUsers);

    @Query("SELECT EXISTS (SELECT * from RoomUsers where userName=:userName)")
    boolean isTaken(String userName);

    @Query("SELECT EXISTS (SELECT * from RoomUsers where userName=:userName AND userPassword=:userPassword)")
    boolean login(String userName, String userPassword);
}
