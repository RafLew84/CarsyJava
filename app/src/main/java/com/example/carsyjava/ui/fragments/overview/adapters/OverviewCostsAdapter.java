package com.example.carsyjava.ui.fragments.overview.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.carsyjava.data.Car;
import com.example.carsyjava.data.DataProvider;
import com.example.carsyjava.databinding.CostOverviewItemRecyclerviewBinding;

import java.util.List;

public class OverviewCostsAdapter extends RecyclerView.Adapter<OverviewCostsViewHolder> {

    private final List<Car> cars = DataProvider.cars;

    @NonNull
    @Override
    public OverviewCostsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CostOverviewItemRecyclerviewBinding binding = CostOverviewItemRecyclerviewBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false);
        return new OverviewCostsViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(OverviewCostsViewHolder holder, int position) {
        Car item = cars.get(position);
        holder.bind(item);
    }

    @Override
    public int getItemCount() {
        return cars.size();
    }
}

