package com.sid.practice.streams;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StreamsExamplesTest {

    @Test
    public void shouldGetDishNamesFilteredAndSorted(){
        String[] dishNamesWithLowerCaloriesThan = StreamsExamples.getDishNamesWithLowerCaloriesThan(200, null);
        Assertions.assertArrayEquals(new String[]{"Salad", "Greens"}, dishNamesWithLowerCaloriesThan);
    }


}