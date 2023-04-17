package com.example.carsyjava.ui.fragments.overview;

import static com.example.carsyjava.util.StringUtil.decimalFormat;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.carsyjava.R;
import com.example.carsyjava.data.Cost;
import com.example.carsyjava.data.CostType;
import com.example.carsyjava.data.DataProvider;
import com.example.carsyjava.databinding.FragmentOverviewBinding;
import com.example.carsyjava.ui.fragments.overview.adapters.OverviewCarsAdapter;
import com.example.carsyjava.ui.fragments.overview.adapters.OverviewCostsAdapter;

public class OverviewFragment extends Fragment {

    private FragmentOverviewBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentOverviewBinding.inflate(inflater);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupCostsUi();
        setupGarageUi();
        setupTotalCostsUi();
    }

    private void setupCostsUi() {
        binding.overviewCostsRecyclerView.setLayoutManager(new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false));
        binding.overviewCostsRecyclerView.setAdapter(new OverviewCostsAdapter());
    }

    private void setupGarageUi() {
        binding.overviewCarsRecyclerView.setLayoutManager(new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false));
        binding.overviewCarsRecyclerView.setAdapter(new OverviewCarsAdapter());
    }

    private void setupTotalCostsUi() {
        binding.overviewFueling.setText(totalValue(CostType.REFUELING));
        binding.overviewService.setText(totalValue(CostType.SERVICE));
        binding.overviewParking.setText(totalValue(CostType.PARKING));
        binding.overviewInsurance.setText(totalValue(CostType.INSURANCE));
        binding.overviewTicket.setText(totalValue(CostType.TICKET));
    }

    private String totalValue(CostType costType) {
        return decimalFormat.format(
                DataProvider.cars.stream()
                        .flatMap(car -> car.getCosts().stream())
                        .filter(cost -> cost.getType() == costType)
                        .mapToDouble(Cost::getAmount)
                        .sum()
        );
    }

}