package com.example.carsyjava.data;

import static com.example.carsyjava.util.DateMapperUtil.polishMonthsNames;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public final class DataProvider {
    private DataProvider() {}
//    public static List<Car> cars = Arrays.asList(
//            new Car("Domowy", "Skoda", "Fabia", 2002, generalCosts(100)),
//            new Car("Służbowy", "BMW", "Coupe", 2015, generalCosts(200)),
//            new Car("Kolekcjonerski", "Fiat", "125p", 1985, generalCosts(120)),
//            new Car("Sportowy", "Lamborghini", "Murcielago", 2012, generalCosts(100)),
//            new Car("Zapasowy", "Skoda", "Superb", 2010, generalCosts(120)),
//            new Car("SUV", "Skoda", "Kodiaq", 2020, generalCosts(300))
//    );


    public static List<Cost> generalCosts(int size) {
        List<Cost> costs = new ArrayList<>();
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
        return costs.stream()
                .sorted(Comparator.comparing(Cost::getDate))
                .collect(Collectors.groupingBy(cost -> cost.getDate().getYear()))
                .entrySet().stream()
                .flatMap(entry -> costListItemsByMonths(entry.getKey(), entry.getValue()).stream())
                .collect(Collectors.toList());
    }

    private static List<CostListItem> costListItemsByMonths(int year, List<Cost> costsOfYear) {
        List<CostListItem> items = new ArrayList<>();
        items.add(new CostListItem.CostYearItem(String.valueOf(year)));
        List<CostListItem> costListItemsByDays = costsOfYear.stream()
                .collect(Collectors.groupingBy(cost -> cost.getDate().getMonth()))
                .entrySet().stream()
                .flatMap(entry -> costListItemsByDays(entry.getKey(), entry.getValue()).stream())
                .collect(Collectors.toList());
        items.addAll(costListItemsByDays);
        return items;
    }

    private static List<CostListItem> costListItemsByDays(Month month, List<Cost> costsOfMonth) {
        List<CostListItem> items = new ArrayList<>();
        items.add(new CostListItem.CostMonthItem(polishMonthsNames(month)));
        List<CostListItem> costListItems = costsOfMonth.stream()
                .sorted(Comparator.comparingInt(c -> c.getDate().getDayOfMonth()))
                .map(CostListItem.CostGeneralItem::new)
                .collect(Collectors.toList());
        items.addAll(costListItems);
        return items;
    }
}