package com.example.carsyjava.ui.fragments.timeline;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.carsyjava.data.DataProvider;
import com.example.carsyjava.databinding.FragmentTimeLineBinding;
import com.example.carsyjava.ui.fragments.timeline.adapters.TimeLineAdapter;

public class TimeLineFragment extends Fragment {

    private FragmentTimeLineBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentTimeLineBinding.inflate(inflater);
        setupRecyclerView();
        return binding.getRoot();
    }

    private void setupRecyclerView() {
        RecyclerView recyclerView = binding.timeLineRecyclerView;
        recyclerView.setAdapter(new TimeLineAdapter(DataProvider.cars.get(0).getCosts(), requireContext()));
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
    }

}