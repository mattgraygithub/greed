package com.greed.service;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class DiceCounterTest {

    private DiceCounter diceCounter = new DiceCounter();

    private Map<Integer, Integer> testMap = new HashMap<Integer, Integer>() {{
        put(1, 2);
        put(2, 0);
        put(3, 3);
        put(4, 0);
        put(5, 1);
        put(6, 0);
    }};

    @Test
    public void shouldReturnNumberOfEachDieThrown() {

        assertThat(diceCounter.count(new String[]{"1", "1", "3", "3", "3", "5"}), is(testMap));
    }
}
