package com.example.roomdb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RoomDatabaseUsers roomDatabaseUsers;
    RoomDAO roomDAO;

    EditText userName, userPassword;
    Button registerButton;
    TextView gotologin;

    public static boolean isAllowed = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userName = (EditText) findViewById(R.id.userName);
        userPassword = (EditText) findViewById(R.id.userPassword);
        registerButton = (Button) findViewById(R.id.registerButton);
        gotologin = (TextView) findViewById(R.id.gotologin);

        roomDatabaseUsers = Room.databaseBuilder(this, RoomDatabaseUsers.class, "roomusers")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();

        roomDAO = roomDatabaseUsers.getDAO();

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RoomUsers roomUsers = new RoomUsers(0, userName.getText().toString(), userPassword.getText().toString());
                roomDAO.insert(roomUsers);
                Toast.makeText(MainActivity.this, "User registered", Toast.LENGTH_SHORT).show();
            }
        });

        gotologin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
            }
        });
    }
}