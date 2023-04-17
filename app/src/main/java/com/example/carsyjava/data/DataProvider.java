package com.example.carsyjava.data;

import static com.example.carsyjava.util.DateMapperUtil.polishMonthsNames;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;

public final class DataProvider {
    private DataProvider() {}
    public static List<Car> cars = Arrays.asList(
            new Car("Domowy", "Skoda", "Fabia", 2002, generalCosts(100)),
            new Car("Służbowy", "BMW", "Coupe", 2015, generalCosts(200)),
            new Car("Kolekcjonerski", "Fiat", "125p", 1985, generalCosts(120)),
            new Car("Sportowy", "Lamborghini", "Murcielago", 2012, generalCosts(100)),
            new Car("Zapasowy", "Skoda", "Superb", 2010, generalCosts(120)),
            new Car("SUV", "Skoda", "Kodiaq", 2020, generalCosts(300))
    );


    private static ArrayList<Cost> generalCosts(int size) {
        ArrayList<Cost> costs = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            costs.add(new Cost(
                    CostType.values()[new Random().nextInt(CostType.values().length)],
                    LocalDate.of(new Random().nextInt(18) + 2005, new Random().nextInt(11)+1, new Random().nextInt(27)+1),
                    new Random().nextInt(5000)
            ));
        }
        return costs;
    }

    public static List<CostListItem> getTimeLineList(List<Cost> costs) {
        List<Cost> sortedCosts = costs.stream()
                .sorted(Comparator.comparing(Cost::getDate))
                .collect(Collectors.toList());
        List<CostListItem> items = new ArrayList<>();
        int currentYear = -1;
        int currentMonth = -1;
        for (Cost cost : sortedCosts) {
            LocalDate date = cost.getDate();
            if (date.getYear() != currentYear) {
                items.add(new CostListItem.CostYearItem(String.valueOf(date.getYear())));
                currentYear = date.getYear();
                currentMonth = -1;
            }
            if (date.getMonthValue() != currentMonth) {
                items.add(new CostListItem.CostMonthItem(polishMonthsNames(date.getMonth())));
                currentMonth = date.getMonthValue();
            }
            items.add(new CostListItem.CostGeneralItem(cost));
        }
        return items;
    }
}