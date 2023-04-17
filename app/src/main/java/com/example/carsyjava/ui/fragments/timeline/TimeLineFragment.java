package com.example.carsyjava.ui.fragments.timeline;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import com.example.carsyjava.R;
import com.example.carsyjava.data.Car;
import com.example.carsyjava.data.DataProvider;
import com.example.carsyjava.databinding.FragmentTimeLineBinding;
import com.example.carsyjava.ui.fragments.timeline.adapters.TimeLineAdapter;

import java.util.stream.Collectors;

public class TimeLineFragment extends Fragment {

    private FragmentTimeLineBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentTimeLineBinding.inflate(inflater);

        return binding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();
        final RecyclerView recyclerView = setupRecyclerView();
        setupDropDownSelector(recyclerView);
    }

    private RecyclerView setupRecyclerView() {
        RecyclerView recyclerView = binding.timeLineRecyclerView;
        recyclerView.setAdapter(new TimeLineAdapter(DataProvider.cars.get(0).getCosts(), requireContext()));
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        return recyclerView;
    }

    private void setupDropDownSelector(RecyclerView recycler) {
        AutoCompleteTextView textView = binding.autoCompleteTextView;
        textView.setDropDownBackgroundResource(R.color.dark_blue_900);

        if (textView.getText().toString().isEmpty())
            textView.setText(DataProvider.cars.get(0).getName());

        ArrayAdapter<String> adapter = getStringArrayAdapter();
        textView.setAdapter(adapter);

        setAdapterAtPosition(recycler);

        textView.setOnItemClickListener((parent, view, position, id) ->
                getAdapter(recycler, position));
    }

    private void setAdapterAtPosition(RecyclerView recycler) {
        int itemPosition = -1;
        for (int i = 0; i < DataProvider.cars.size(); i++) {
            if (DataProvider
                    .cars
                    .get(i)
                    .getName()
                    .equals(binding.autoCompleteTextView.getText().toString())) {
                itemPosition = i;
                break;
            }
        }

        if (itemPosition != -1) {
            getAdapter(recycler, itemPosition);
        }
    }

    private void getAdapter(RecyclerView recycler, int position) {
        recycler.swapAdapter(
                new TimeLineAdapter(
                        DataProvider.cars.get(position).getCosts(),
                        requireContext()
                ),
                true);
    }

    @NonNull
    private ArrayAdapter<String> getStringArrayAdapter() {
        return new ArrayAdapter<>(
                requireContext(),
                R.layout.dropdown_item,
                DataProvider.cars.stream()
                        .map(Car::getName)
                        .collect(Collectors.toList()));
    }
}