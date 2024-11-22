package com.example.lab_2;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<Task> toDoList = new ArrayList<>();
        toDoList.add(new Task("Сходить в магазин", "12:00"));
        toDoList.add(new Task("Сделать практику по андроиду", "14:00"));
        toDoList.add(new Task("Приготовить покушать", "17:00"));
        toDoList.add(new Task("Сходить на тренировку", "19:00"));

        recyclerView.setAdapter(new TasksAdapter(toDoList));

    }
}
