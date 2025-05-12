package com.example.roomies;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        Button homescreenButton = findViewById(R.id.back_button1);
        Button jobsButton = findViewById(R.id.jobs_button);
        Button groceriesButton = findViewById(R.id.groceries_button);
        Button calendarButton = findViewById(R.id.calendar_button);

        jobsButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainMenu.this, Jobs.class);
            startActivity(intent);
        });

        groceriesButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainMenu.this, Groceries.class);
            startActivity(intent);
        });

        calendarButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainMenu.this, Calendar.class);
            startActivity(intent);
        });

        homescreenButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainMenu.this, TitleScreen.class);
            startActivity(intent);
        });
    }
}