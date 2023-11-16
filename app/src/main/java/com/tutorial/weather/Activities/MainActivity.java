package com.tutorial.weather.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.tutorial.weather.Adapters.HourlyAdapters;
import com.tutorial.weather.Domains.Hourly;
import com.tutorial.weather.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapterHourly;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        initRecyclerview();

        next7day();
    }

    private void next7day() {
        TextView tomorrow = findViewById(R.id.next7day);

        tomorrow.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, FutureActivity.class));
        });



    }

    private void initRecyclerview() {
        ArrayList<Hourly> items = new ArrayList<>();

        items.add(new Hourly("9 pm", 28, "cloudy"));
        items.add(new Hourly("10 pm", 29, "sunny"));
        items.add(new Hourly("11 pm", 30, "wind"));
        items.add(new Hourly("12 pm", 31, "rainy"));
        items.add(new Hourly("1 am", 32, "storm"));

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(
                new LinearLayoutManager(this,
                LinearLayoutManager.HORIZONTAL,
                false));

        adapterHourly = new HourlyAdapters(items);
        recyclerView.setAdapter(adapterHourly);

    }
}
