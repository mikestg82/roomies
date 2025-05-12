package com.example.roomies;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class TitleScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title_screen);

        // Initialize button using findViewById
        // Declare Button object
        Button nextActivityButton = findViewById(R.id.button1);

        // Set click listener for the button
        nextActivityButton.setOnClickListener(v -> {
            // Create Intent to start SecondActivity
            Intent intent = new Intent(TitleScreen.this, MainMenu.class);
            // Start the activity
            startActivity(intent);
        });
    }
}