package com.example.javaproject;

public class Vehicle {
    private String make, type, model;
    private String year, engineSize, price;
    private int vistedTims = 0;

    public Vehicle(String make, String type, String model, String year, String engineSize, String price) {
        this.make = make;
        this.type = type;
        this.model = model;
        this.year = year;
        this.engineSize = engineSize;
        this.price = price;

    }

    public int getVistedTims() {
        return vistedTims;
    }

    public void setVistedTims() {
        this.vistedTims = vistedTims + 1;
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

    public String getPrice() {
        return price;
    }


    public String getYear() {
        return year;
    }

    public String getEngineSize() {
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

    public void setYear(String year) {
        this.year = year;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setEngineSize(String engineSize) {
        this.engineSize = engineSize;
    }
}
