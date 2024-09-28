package com.example.prac3;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CountryViewHolder> {

    private Context context;
    private List<Country> countryList;

    public CountryAdapter(Context context, List<Country> countryList) {
        this.context = context;
        this.countryList = countryList;
    }

    @NonNull
    @Override
    public CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_item_country, parent, false);
        return new CountryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryViewHolder holder, int position) {
        Country country = countryList.get(position);
        holder.flagImageView.setImageResource(country.getFlagResource());
        holder.countryNameTextView.setText(country.getName());
        holder.capitalTextView.setText(country.getCapital());

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, CountryDetailActivity.class);
            intent.putExtra("countryName", country.getName());
            intent.putExtra("capital", country.getCapital()); // Thêm dòng này
            intent.putExtra("flagResource", country.getFlagResource()); // Thêm dòng này
            intent.putExtra("population", country.getPopulation());
            intent.putExtra("area", country.getArea());
            intent.putExtra("density", country.getDensity());
            context.startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {
        return countryList.size();
    }

    public static class CountryViewHolder extends RecyclerView.ViewHolder {
        ImageView flagImageView;
        TextView countryNameTextView, capitalTextView;

        public CountryViewHolder(@NonNull View itemView) {
            super(itemView);
            flagImageView = itemView.findViewById(R.id.flagImageView);
            countryNameTextView = itemView.findViewById(R.id.countryNameTextView);
            capitalTextView = itemView.findViewById(R.id.capitalTextView);
        }
    }
}
