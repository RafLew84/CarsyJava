package com.example.carsyjava.ui.fragments.timeline.adapters;

import androidx.recyclerview.widget.RecyclerView;

import com.example.carsyjava.data.CostListItem;
import com.example.carsyjava.databinding.MonthItemTimelineRecyclerviewBinding;

public class MonthItemViewHolder extends RecyclerView.ViewHolder {
    private MonthItemTimelineRecyclerviewBinding binding;

    public MonthItemViewHolder(MonthItemTimelineRecyclerviewBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(CostListItem.CostMonthItem item) {
        binding.timeLineMonthTextView.setText(item.getMonth());
    }
}

