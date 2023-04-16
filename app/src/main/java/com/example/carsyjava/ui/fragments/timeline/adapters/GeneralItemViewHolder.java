package com.example.carsyjava.ui.fragments.timeline.adapters;

import static com.example.carsyjava.util.StringUtil.dateFormatter;

import android.annotation.SuppressLint;
import android.content.Context;

import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.carsyjava.data.CostListItem;
import com.example.carsyjava.databinding.GeneralItemTimelineRecyclerviewBinding;

public class GeneralItemViewHolder extends RecyclerView.ViewHolder {
    private GeneralItemTimelineRecyclerviewBinding binding;

    public GeneralItemViewHolder(GeneralItemTimelineRecyclerviewBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    @SuppressLint("SetTextI18n")
    public void bind(CostListItem.CostGeneralItem item, Context context) {
        binding.timeLineCostTypeNameTextView.setText(item.getCost().getType().getCostType());
        binding.timeLineFullDateTextView.setText(item.getCost().getDate().format(dateFormatter));
        binding.timeLineCostAmountTextView.setText(item.getCost().getAmount() + " zł");
        binding.iconTimeLineImageView.setBackground(ContextCompat.getDrawable(context, item.getCost().getType().getIcon()));
    }
}
