package com.example.carsyjava.ui.fragments.timeline.adapters;

import androidx.recyclerview.widget.RecyclerView;

import com.example.carsyjava.data.CostListItem;
import com.example.carsyjava.databinding.YearItemTimelineRecyclerviewBinding;

public class YearItemViewHolder extends RecyclerView.ViewHolder {
    private YearItemTimelineRecyclerviewBinding binding;

    public YearItemViewHolder(YearItemTimelineRecyclerviewBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(CostListItem.CostYearItem item) {
        binding.timeLineYearTextView.setText(item.getYear());
    }
}
