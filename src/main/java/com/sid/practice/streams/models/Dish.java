package com.sid.practice.streams.models;

public class Dish {
    private final String name;
    private final int calories;
    private final int price;

    public Dish(String name, int calories, int price){
        this.name = name;
        this.calories = calories;
        this.price = price;
    }

    public int getCalories() {
        return calories;
    }

    public String getName() {
        return name;
    }
}
