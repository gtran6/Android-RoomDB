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

public class LoginActivity extends AppCompatActivity {

    EditText userName, userPassword;
    Button loginButton;
    TextView gotosignup;

    RoomDatabaseUsers roomDatabaseUsers;
    RoomDAO roomDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userName = (EditText) findViewById(R.id.userName);
        userPassword = (EditText) findViewById(R.id.userPassword);
        loginButton = (Button) findViewById(R.id.loginButton);
        gotosignup = (TextView) findViewById(R.id.gotosignup);

        roomDatabaseUsers = Room.databaseBuilder(this, RoomDatabaseUsers.class, "roomusers")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();

        roomDAO = roomDatabaseUsers.getDAO();

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = userName.getText().toString();
                String userpassword = userPassword.getText().toString();
                if (roomDAO.login(username, userpassword)) {
                    startActivity(new Intent(LoginActivity.this, DashboardActivity.class));
                } else {
                    Toast.makeText(LoginActivity.this, "Invalid User name or Password", Toast.LENGTH_SHORT).show();
                }
            }
        });

        gotosignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });
    }
}