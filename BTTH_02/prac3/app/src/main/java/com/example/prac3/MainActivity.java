package com.example.prac3;



import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.prac3.Country;
import com.example.prac3.CountryAdapter;
import com.example.prac3.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CountryAdapter adapter;
    private List<Country> countryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        countryList = new ArrayList<>();
        countryList.add(new Country("Viet Nam", "Hanoi", R.drawable.vietnam, 96208984, 331212));
        countryList.add(new Country("USA", "Washington D.C", R.drawable.usa, 125800000, 377975));
        countryList.add(new Country("China", "Beijing", R.drawable.china, 1331000000, 13833520));
        countryList.add(new Country("India", "New Delhi", R.drawable.india, 1831000000, 19833520));
        countryList.add(new Country("Spain", "Madrid", R.drawable.spain, 23310000, 13833520));
        countryList.add(new Country("Greek", "Athens", R.drawable.greek, 11000000, 198520));
        // Thêm nhiều quốc gia khác nếu cần

        adapter = new CountryAdapter(this, countryList);
        recyclerView.setAdapter(adapter);
    }
}
