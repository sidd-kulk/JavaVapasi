package com.sid.practice.streams;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.bag.CollectionBag;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StreamsExamples {

    public static String[] getDishNamesWithLowerCaloriesThan(int caloriesLimit, List<Dish> dishes) {
        if (CollectionUtils.isEmpty(dishes)) {
            dishes = List.of(
                    new Dish("Pasta", 1200, 34),
                    new Dish("Cake", 1000, 22),
                    new Dish("Salad", 120, 45),
                    new Dish("Greens", 130, 47));
        }

        return dishes.stream().filter( dish -> dish.getCalories() < caloriesLimit)
                              .sorted(Comparator.comparing(Dish::getCalories))
                              .map(Dish::getName).toArray(String[]::new);
    }

    private static class Dish {
        private final String name;
        private final int calories;
        private final int price;

        Dish(String name, int calories, int price){
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
}
