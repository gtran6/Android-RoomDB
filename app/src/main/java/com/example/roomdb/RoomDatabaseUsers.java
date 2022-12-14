package com.example.roomdb;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {RoomUsers.class}, version = 1)
public abstract class RoomDatabaseUsers extends RoomDatabase {
    public abstract RoomDAO getDAO();

}
