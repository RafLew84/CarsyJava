package com.example.carsyjava.ui.fragments.calculators;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.carsyjava.R;
import com.example.carsyjava.databinding.FragmentCalculatorBinding;

public class CalculatorsFragment extends Fragment {

    private FragmentCalculatorBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCalculatorBinding.inflate(inflater);
        return binding.getRoot();
    }
}