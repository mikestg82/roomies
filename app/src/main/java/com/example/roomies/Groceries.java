package com.example.roomies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Groceries extends AppCompatActivity
{
    public List<String> groceryList;
    private groceries_adapter adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groceries);

        groceryList = new ArrayList<>();
        adapter = new groceries_adapter(groceryList);

        recyclerView = findViewById(R.id.list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        ImageButton add_Item = findViewById(R.id.add_item);

        Button homescreenButton = findViewById(R.id.back_button1);
        homescreenButton.setOnClickListener(v -> {
            Intent intent = new Intent(Groceries.this, MainMenu.class);
            startActivity(intent);
        });

        add_Item.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                View task_dialog = LayoutInflater.from(Groceries.this).inflate(R.layout.groceries_add, null);

                AlertDialog.Builder b = new AlertDialog.Builder(Groceries.this);
                b.setView(task_dialog);

                EditText ask_item = task_dialog.findViewById(R.id.new_groceries);
                Button cancel = task_dialog.findViewById(R.id.c_t);
                Button add = task_dialog.findViewById(R.id.a_t);

                AlertDialog d = b.create();
                d.show();

                cancel.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        d.dismiss();
                    }
                });

                add.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        String task = ask_item.getText().toString().trim();

                        if (!task.isEmpty())
                        {
                            groceryList.add(task);
                            adapter.notifyItemInserted(groceryList.size() - 1);
                            d.dismiss();
                        }
                        else
                        {
                            Toast.makeText(Groceries.this, "Please enter a task", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
}