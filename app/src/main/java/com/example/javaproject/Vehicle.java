package com.example.javaproject;

public class Vehicle {
    private String make, type, model;
    private int year, engineSize, price;

    public Vehicle(String make, String type, String model, int year, int engineSize, int price) {
        this.make = make;
        this.type = type;
        this.model = model;
        this.year = year;
        this.engineSize = engineSize;
        this.price = price;
    }

    public String getMake() {
        return make;
    }

    public String getType() {
        return type;
    }

    public String getModel() {
        return model;
    }

    public int getPrice() {
        return price;
    }


    public int getYear() {
        return year;
    }

    public int getEngineSize() {
        return engineSize;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setEngineSize(int engineSize) {
        this.engineSize = engineSize;
    }
}
