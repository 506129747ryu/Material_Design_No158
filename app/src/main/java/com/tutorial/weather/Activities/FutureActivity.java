package com.tutorial.weather.Activities;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.tutorial.weather.Adapters.FutureAdapters;
import com.tutorial.weather.Domains.FutureDomain;
import com.tutorial.weather.R;

import java.util.ArrayList;

public class FutureActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapterTomorrow;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_future);

        initRecyclerview();
        setVariable();
    }

    private void setVariable() {
        ConstraintLayout backBtn = findViewById(R.id.backBtn);

        backBtn.setOnClickListener(view ->
                startActivity(new Intent(FutureActivity.this, MainActivity.class)));
    }

    private void initRecyclerview() {
        ArrayList<FutureDomain> items = new ArrayList<>();

        items.add(new FutureDomain("Sat",  "cloudy", "Cloudy", 28, 20));
        items.add(new FutureDomain("Sun",  "storm", "Wind", 25, 21));
        items.add(new FutureDomain("Mon",  "sunny", "Sunny", 32, 19));
        items.add(new FutureDomain("Thu",  "wind", "Storm", 23, 18));
        items.add(new FutureDomain("Wed",  "rain", "Rain", 30, 23));

        recyclerView = findViewById(R.id.future_view);
        recyclerView.setLayoutManager(
                new LinearLayoutManager(this,
                        LinearLayoutManager.VERTICAL,
                        false));

        adapterTomorrow = new FutureAdapters(items);
        recyclerView.setAdapter(adapterTomorrow);

    }
}
