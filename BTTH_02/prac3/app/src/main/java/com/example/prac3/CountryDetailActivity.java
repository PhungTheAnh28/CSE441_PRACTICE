package com.example.prac3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CountryDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_detail);

        ImageView flagImageView = findViewById(R.id.flagImageView);
        TextView countryNameTextView = findViewById(R.id.countryNameTextView);
        TextView capitalTextView = findViewById(R.id.capitalTextView);
        TextView populationTextView = findViewById(R.id.populationTextView);
        TextView areaTextView = findViewById(R.id.areaTextView);
        TextView densityTextView = findViewById(R.id.densityTextView);

        String countryName = getIntent().getStringExtra("countryName");
        String capital = getIntent().getStringExtra("capital");
        int flagResource = getIntent().getIntExtra("flagResource", 0);
        int population = getIntent().getIntExtra("population", 0);
        int area = getIntent().getIntExtra("area", 0);
        int density = getIntent().getIntExtra("density", 0);

        countryNameTextView.setText(countryName);
        capitalTextView.setText("Capital: " + capital);
        flagImageView.setImageResource(flagResource);
        populationTextView.setText("Population: " + population);
        areaTextView.setText("Area: " + area + " sq km");
        densityTextView.setText("Density: " + density + " people/KM2");
    }
}
