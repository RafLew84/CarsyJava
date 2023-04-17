package com.example.carsyjava.ui.fragments.overview.adapters;

import static com.example.carsyjava.util.StringUtil.decimalFormat;

import androidx.recyclerview.widget.RecyclerView;

import com.example.carsyjava.data.Car;
import com.example.carsyjava.data.Cost;
import com.example.carsyjava.data.CostType;
import com.example.carsyjava.databinding.CostOverviewItemRecyclerviewBinding;

public class OverviewCostsViewHolder extends RecyclerView.ViewHolder {

    private final CostOverviewItemRecyclerviewBinding binding;

    public OverviewCostsViewHolder(CostOverviewItemRecyclerviewBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(Car item) {
        binding.overviewRecyclerViewCarName.setText(item.getName());
        binding.overviewRecyclerViewFueling.setText(costValue(item, CostType.REFUELING));
        binding.overviewRecyclerViewService.setText(costValue(item, CostType.SERVICE));
        binding.overviewRecyclerViewParking.setText(costValue(item, CostType.PARKING));
        binding.overviewRecyclerViewInsurance.setText(costValue(item, CostType.INSURANCE));
        binding.overviewRecyclerViewTicket.setText(costValue(item, CostType.TICKET));
    }

    private String costValue(Car item, CostType costType) {
        double totalCost = item.getCosts()
                .stream()
                .filter(cost -> cost.getType() == costType)
                .mapToDouble(Cost::getAmount)
                .sum();
        return decimalFormat.format(totalCost);
    }
}

