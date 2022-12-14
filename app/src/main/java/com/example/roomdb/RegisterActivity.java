package com.example.roomdb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    RoomDatabaseUsers roomDatabaseUsers;
    RoomDAO roomDAO;

    EditText userName, userPassword, name, userHomeAddress, userWorkAddress;
    Button registerButton;
    TextView gotologin;

    public static boolean isAllowed = false;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        userName = (EditText) findViewById(R.id.userName);
        userPassword = (EditText) findViewById(R.id.userPassword);
        registerButton = (Button) findViewById(R.id.registerButton);
        gotologin = (TextView) findViewById(R.id.gotologin);
        name = (EditText) findViewById(R.id.name);
        userHomeAddress = (EditText) findViewById(R.id.userHomeAddress);
        userWorkAddress = (EditText) findViewById(R.id.userWorkAddress);

        roomDatabaseUsers = Room.databaseBuilder(this, RoomDatabaseUsers.class, "roomusers")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();

        roomDAO = roomDatabaseUsers.getDAO();

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RoomUsers roomUsers = new RoomUsers(0,
                        userName.getText().toString(),
                        userPassword.getText().toString(),
                        name.getText().toString(),
                        userHomeAddress.getText().toString(),
                        userWorkAddress.getText().toString());
                roomDAO.insert(roomUsers);
                Toast.makeText(RegisterActivity.this, "User registered", Toast.LENGTH_SHORT).show();
            }
        });

        gotologin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            }
        });
    }
}