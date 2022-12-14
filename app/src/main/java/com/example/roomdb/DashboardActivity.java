package com.example.roomdb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class DashboardActivity extends AppCompatActivity {

    TextView name, userHomeAddress, userWorkAddress;
    RoomDatabaseUsers roomDatabaseUsers;
    RoomDAO roomDAO;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        name = (EditText) findViewById(R.id.name);
        userHomeAddress = (EditText) findViewById(R.id.userHomeAddress);
        userWorkAddress = (EditText) findViewById(R.id.userWorkAddress);

        roomDatabaseUsers = Room.databaseBuilder(this, RoomDatabaseUsers.class, "roomusers")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();

        roomDAO = roomDatabaseUsers.getDAO();



    }
}