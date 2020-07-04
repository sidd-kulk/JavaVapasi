package com.sid.practice.streams;


import com.github.javafaker.Faker;
import com.sid.practice.streams.models.Dish;
import org.apache.commons.lang3.time.StopWatch;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

class StreamsExamplesTest {

    @Test
    public void shouldGetDishNamesFilteredAndSorted(){
        String[] dishNamesWithLowerCaloriesThan = StreamsExamples.getDishNamesWithLowerCaloriesThan(200, null);
        Assertions.assertArrayEquals(new String[]{"Salad", "Greens"}, dishNamesWithLowerCaloriesThan);
    }

    @Test
    public void performanceTest(){
        StopWatch watch = new StopWatch();
        List<Dish> dishes = getRandomDishes();
        watch.start();
        StreamsExamples.getDishNamesWithLowerCaloriesThan(500, dishes);
        watch.stop();
        System.out.println("Time taken == "+ watch.getNanoTime());



        StopWatch watch1 = new StopWatch();
        dishes = getRandomDishes();
        watch1.start();
        StreamsExamples.getDishNamesWithLowerCaloriesThanPar(500, dishes);
        watch1.stop();
        System.out.println("Time taken == "+ watch1.getNanoTime());

    }

    private List<Dish> getRandomDishes(){
        Faker f = new Faker();
        List<Dish> dishes = new ArrayList<>();
        for(int i=0;i<100000;i++) {
            String dishName = f.letterify("a??efghij???opqrstuvw??yz");
            int calories = Integer.parseInt(f.numerify("###0"));
            int price = calories * 2;
            dishes.add(new Dish(dishName, calories, price));
        }
        return dishes;
    }


}