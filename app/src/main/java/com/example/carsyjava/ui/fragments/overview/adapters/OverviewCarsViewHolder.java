package com.example.carsyjava.ui.fragments.overview.adapters;

import static com.example.carsyjava.util.StringUtil.decimalFormat;

import androidx.recyclerview.widget.RecyclerView;

import com.example.carsyjava.data.Car;
import com.example.carsyjava.data.Cost;
import com.example.carsyjava.databinding.CarsOverviewItemRecyclerviewBinding;

class OverviewCarsViewHolder extends RecyclerView.ViewHolder {

    private final CarsOverviewItemRecyclerviewBinding binding;

    public OverviewCarsViewHolder(CarsOverviewItemRecyclerviewBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(Car item) {
        binding.overviewViewPagerCarName.setText(item.getName());
        binding.overviewViewPagerBrand.setText(item.getBrand());
        binding.overviewViewPagerModel.setText(item.getModel());
        binding.overviewViewPagerYearOfProduction.setText(String.valueOf(item.getYearOfProduction()));
        double totalCosts = item.getCosts().stream().mapToDouble(Cost::getAmount).sum();
        binding.overviewViewPagerTotalCosts.setText(decimalFormat.format(totalCosts));
    }
}
