package com.example.javaproject;

public class Category {
    private String category, information1,information2;

    public Category(String category, String information1, String information2) {
        this.category = category;
        this.information1 = information1;
        this.information2 = information2;
    }


    public String getInformation1() {
        return information1;
    }

    public String getInformation2() {
        return information2;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setInformation1(String information1) {
        this.information1 = information1;
    }

    public void setInformation2(String information2) {
        this.information2 = information2;
    }
}
