package com.example.carsyjava.ui.fragments.overview;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.carsyjava.R;
import com.example.carsyjava.databinding.FragmentOverviewBinding;

public class OverviewFragment extends Fragment {

    private FragmentOverviewBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentOverviewBinding.inflate(inflater);
        return binding.getRoot();
    }
}