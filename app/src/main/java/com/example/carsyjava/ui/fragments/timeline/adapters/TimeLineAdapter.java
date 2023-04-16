package com.example.carsyjava.ui.fragments.timeline.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.carsyjava.data.Cost;
import com.example.carsyjava.data.CostListItem;
import com.example.carsyjava.data.DataProvider;
import com.example.carsyjava.databinding.GeneralItemTimelineRecyclerviewBinding;
import com.example.carsyjava.databinding.MonthItemTimelineRecyclerviewBinding;
import com.example.carsyjava.databinding.YearItemTimelineRecyclerviewBinding;

import java.util.List;

public class TimeLineAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final List<CostListItem> itemList;
    private final Context context;

    public TimeLineAdapter(List<Cost> costsList, Context context) {
        this.context = context;
        itemList = DataProvider.getTimeLineList(costsList);
    }

    @Override
    public int getItemViewType(int position) {
        return itemList.get(position).getType();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case CostListItem.TYPE_YEAR:
                return createYearItemViewHolder(parent);
            case CostListItem.TYPE_MONTH:
                return createMonthItemViewHolder(parent);
            default:
                return createGeneralItemViewHolder(parent);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (holder.getItemViewType()) {
            case CostListItem.TYPE_YEAR:
                ((YearItemViewHolder) holder).bind((CostListItem.CostYearItem) itemList.get(position));
                break;
            case CostListItem.TYPE_MONTH:
                ((MonthItemViewHolder) holder).bind((CostListItem.CostMonthItem) itemList.get(position));
                break;
            case CostListItem.TYPE_GENERAL:
                ((GeneralItemViewHolder) holder).bind((CostListItem.CostGeneralItem) itemList.get(position), context);
                break;
            default:
                throw new IllegalArgumentException("Wrong ViewHolder");
        }
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    private YearItemViewHolder createYearItemViewHolder(ViewGroup parent) {
        YearItemTimelineRecyclerviewBinding binding = YearItemTimelineRecyclerviewBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new YearItemViewHolder(binding);
    }

    private MonthItemViewHolder createMonthItemViewHolder(ViewGroup parent) {
        MonthItemTimelineRecyclerviewBinding binding = MonthItemTimelineRecyclerviewBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new MonthItemViewHolder(binding);
    }

    private GeneralItemViewHolder createGeneralItemViewHolder(ViewGroup parent) {
        GeneralItemTimelineRecyclerviewBinding binding = GeneralItemTimelineRecyclerviewBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new GeneralItemViewHolder(binding);
    }
}

