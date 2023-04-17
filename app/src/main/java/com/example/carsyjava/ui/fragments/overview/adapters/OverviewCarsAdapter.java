package com.example.carsyjava.ui.fragments.overview.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.carsyjava.data.Car;
import com.example.carsyjava.data.DataProvider;
import com.example.carsyjava.databinding.CarsOverviewItemRecyclerviewBinding;

import java.util.List;

public class OverviewCarsAdapter extends RecyclerView.Adapter<OverviewCarsViewHolder> {

    private final List<Car> cars = DataProvider.cars;

    @NonNull
    @Override
    public OverviewCarsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CarsOverviewItemRecyclerviewBinding binding =
                CarsOverviewItemRecyclerviewBinding.inflate(
                        LayoutInflater.from(parent.getContext()),
                        parent,
                        false);
        return new OverviewCarsViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(OverviewCarsViewHolder holder, int position) {
        Car item = cars.get(position);
        holder.bind(item);
    }

    @Override
    public int getItemCount() {
        return cars.size();
    }
}

