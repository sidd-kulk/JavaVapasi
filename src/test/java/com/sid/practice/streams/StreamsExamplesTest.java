package com.sid.practice.streams;


import com.github.javafaker.Faker;
import com.sid.practice.streams.models.Dish;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class StreamsExamplesTest {

    @Test
    public void shouldGetDishNamesFilteredAndSorted(){
        String[] dishNamesWithLowerCaloriesThan = StreamsExamples.getDishNamesWithLowerCaloriesThan(200, null);
        Assertions.assertArrayEquals(new String[]{"Salad", "Greens"}, dishNamesWithLowerCaloriesThan);
    }

    private List<Dish> getRandomDishes(){
        Faker f = new Faker();
        List<Dish> dishes = new ArrayList<>();
        for(int i=0;i<100;i++) {
            String dishName = f.letterify("a??efghij???opqrstuvw??yz");
            int calories = Integer.parseInt(f.numerify("###0"));
            int price = calories * 2;
            dishes.add(new Dish(dishName, calories, price));
        }
        return dishes;
    }


}