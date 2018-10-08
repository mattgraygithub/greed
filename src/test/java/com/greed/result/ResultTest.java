package com.greed.result;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class ResultTest {

    private Map<Integer, Integer> diceCounts = new HashMap<>();

    @Test
    public void shouldReturnTrueForThreePairsIfThreePairsThrown() {

        diceCounts.put(1,2);
        diceCounts.put(2,2);
        diceCounts.put(3,2);

        assertThat(Result.THREE_PAIRS.isResult(diceCounts), is(true));
    }

    @Test
    public void shouldReturnFalseForThreePairsIfThreePairsNotThrown() {
        diceCounts.put(1, 3);
        diceCounts.put(2, 3);

        assertThat(Result.THREE_PAIRS.isResult(diceCounts), is(false));
    }

    @Test
    public void shouldReturnTrueStraightIfStraightThrown() {

        for (int die = 1; die <= 6; die++) {
            diceCounts.put(die, 1);
        }

        assertThat(Result.STRAIGHT.isResult(diceCounts), is(true));
    }

    @Test
    public void shouldReturnFalseForStraightIfStraightNotThrown() {
        diceCounts.put(1, 3);
        diceCounts.put(2, 3);

        assertThat(Result.STRAIGHT.isResult(diceCounts), is(false));
    }
}
