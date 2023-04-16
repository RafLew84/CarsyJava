package com.example.carsyjava.ui.fragments.timeline;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.carsyjava.R;
import com.example.carsyjava.databinding.FragmentTimeLineBinding;

public class TimeLineFragment extends Fragment {

    private FragmentTimeLineBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentTimeLineBinding.inflate(inflater);
        return binding.getRoot();
    }
}