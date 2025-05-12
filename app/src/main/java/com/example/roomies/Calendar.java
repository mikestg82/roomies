package com.example.roomies;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Calendar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        CalendarView calendar = findViewById(R.id.calendarV);
        TextView dateView = findViewById(R.id.date_view);
        Button homescreenButton = findViewById(R.id.back_button1);

        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                String date = dayOfMonth + "-" + (month + 1) + "-" + year;
                dateView.setText(date);
            }
        });

        homescreenButton.setOnClickListener(v -> {
            Intent intent = new Intent(Calendar.this, MainMenu.class);
            startActivity(intent);
        });
    }
}