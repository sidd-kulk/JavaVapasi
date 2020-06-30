package com.sid.practice.streams;

import com.google.common.collect.ImmutableList;
import com.sid.practice.streams.models.Dish;

import java.util.Comparator;
import java.util.List;

public class StreamsExamples {

    public static String[] getDishNamesWithLowerCaloriesThan(int caloriesLimit, List<Dish> dishes) {
        if (dishes == null || dishes.size() == 0) {
            dishes = ImmutableList.of(
                    new Dish("Pasta", 1200, 34),
                    new Dish("Cake", 1000, 22),
                    new Dish("Salad", 120, 45),
                    new Dish("Greens", 130, 47));
        }

        return dishes.stream().filter( dish -> dish.getCalories() < caloriesLimit)
                              .sorted(Comparator.comparing(Dish::getCalories))
                              .map(Dish::getName).toArray(String[]::new);
    }
}
