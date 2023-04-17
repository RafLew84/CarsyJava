package com.example.carsyjava.data;

import java.util.List;

public class Car {

    private String name;
    private String brand;
    private String model;
    private int yearOfProduction;
    private List<Cost> costs;

    public Car(String name, String brand, String model, int yearOfProduction, List<Cost> costs) {
        this.name = name;
        this.brand = brand;
        this.model = model;
        this.yearOfProduction = yearOfProduction;
        this.costs = costs;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }

    public List<Cost> getCosts() {
        return costs;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYearOfProduction(int yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public void setCosts(List<Cost> costs) {
        this.costs = costs;
    }

}
