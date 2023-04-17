package com.example.carsyjava.ui.fragments.calculators;

import static com.example.carsyjava.util.StringUtil.decimalFormat;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;

import com.example.carsyjava.R;
import com.example.carsyjava.databinding.FragmentCalculatorBinding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import kotlin.Triple;

public class CalculatorsFragment extends Fragment {

    private FragmentCalculatorBinding binding;

    private final Map<Integer, String> calculators = new HashMap<Integer, String>() {{
        put(0, "Koszt podróży");
        put(1, "Odległość");
        put(2, "Wymagane paliwo");
    }};

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCalculatorBinding.inflate(inflater);
        return binding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();
        setupDropDownSelector();
    }

    private void setupDropDownSelector() {
        binding.autoCompleteTextView.setDropDownBackgroundResource(R.color.dark_blue_900);
        binding.autoCompleteTextView.setText(calculators.get(0));
        binding.textViewMainTitle.setText(calculators.get(0));

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                requireContext(),
                R.layout.dropdown_item,
                new ArrayList<>(calculators.values())
        );
        binding.autoCompleteTextView.setAdapter(adapter);
        binding.autoCompleteTextView.setOnItemClickListener(autoCompleteTextViewOnItemClickListener());
    }


    private AdapterView.OnItemClickListener autoCompleteTextViewOnItemClickListener() {
        return (adapterView, view, position, l) -> {
            binding.textViewMainTitle.setText(calculators.get(position));
            String hint = (position == getKeyByValue(calculators)) ? "Paliwo [l]" : "Odległość [km]";
            binding.editInputLayout1.setHint(hint);
            setupCalculateButtonOnClickListener(position);
        };
    }

    private int getKeyByValue(Map<Integer, String> map) {
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if (Objects.equals("Odległość", entry.getValue())) {
                return entry.getKey();
            }
        }
        return -1;
    }


    private void setupCalculateButtonOnClickListener(int position) {
        binding.calculateButton.setOnClickListener(view -> {
            Triple<String, String, String> input = getEditTextsData();

            if (checkForEmptyEditTexts(input)) {
                Pair<String, String> values = calculators(position, input);
                binding.textViewMainValue.setText(values.first);
                binding.textViewBottomValue.setText(values.second);
            }
        });
    }

    private boolean checkForEmptyEditTexts(Triple<String, String, String> input) {
        return input.getFirst().length() > 0
                && input.getSecond().length() > 0
                && input.getThird().length() > 0;
    }

    private Triple<String, String, String> getEditTextsData() {
        EditText editText1 = binding.editText1;
        EditText editText2 = binding.editText2;
        EditText editText3 = binding.editText3;

        return new Triple<>(
                editText1.getText().toString(),
                editText2.getText().toString(),
                editText3.getText().toString()
        );
    }

    private Pair<String, String> calculators(int position, Triple<String, String, String> values) {
        switch(position) {
            case 0:
                return travelCalculator(values);
            case 1:
                return distanceCalculator(values);
            case 2:
                return fuelCalculator(values);
            default:
                return new Pair<>("", "");
        }
    }

    private Pair<String, String> fuelCalculator(Triple<String, String, String> values) {
        double distance = Double.parseDouble(values.getFirst());
        double cost = Double.parseDouble(values.getSecond());
        double fuelUsage = Double.parseDouble(values.getThird());

        double fuelCost = (distance * fuelUsage) / 100;
        double fuelAmount = fuelCost * cost;

        String stringMain = decimalFormat.format(fuelCost);
        String stringBottom = decimalFormat.format(fuelAmount);

        return new Pair<>(stringMain + " l", stringBottom + " zł");
    }

    private Pair<String, String> distanceCalculator(Triple<String, String, String> values) {
        double fuel = Double.parseDouble(values.getFirst());
        double price = Double.parseDouble(values.getSecond());
        double fuelUsage = Double.parseDouble(values.getThird());

        double distance = fuel * price;
        double totalCost = (100 * fuel) / fuelUsage;

        String stringBottom = decimalFormat.format(distance);
        String stringMain = decimalFormat.format(totalCost);

        return new Pair<>(stringMain + " km", stringBottom + " zł");
    }

    private Pair<String, String> travelCalculator(Triple<String, String, String> values) {
        double distance = Double.parseDouble(values.getFirst());
        double price = Double.parseDouble(values.getSecond());
        double fuelUsage = Double.parseDouble(values.getThird());

        double totalFuel = (fuelUsage / 100) * distance;
        double totalPrice = totalFuel * price;

        String stringBottom = decimalFormat.format(totalFuel);
        String stringMain = decimalFormat.format(totalPrice);

        return new Pair<>(stringMain + " zł", stringBottom + " l");
    }

}