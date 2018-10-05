package com.greed.result;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ResultTest {

    private Map<Integer, Integer> diceCounts = new HashMap<>();

    @Test
    public void shouldReturnTrueForThreePairsIfThreePairsThrown(){

        for (int die = 1; die <= 6; die += 2) {
            diceCounts.put(die, 2);
        }

        assertTrue(Result.THREE_PAIRS.isResult(diceCounts));
    }

    @Test
    public void shouldReturnFalseForThreePairsIfThreePairsNotThrown(){
        diceCounts.put(1,3);
        diceCounts.put(2,3);

        assertFalse(Result.THREE_PAIRS.isResult(diceCounts));
    }

    @Test
    public void shouldReturnTrueStraightIfStraightThrown(){

        for (int die = 1; die <= 6; die ++) {
            diceCounts.put(die, 1);
        }

        assertTrue(Result.STRAIGHT.isResult(diceCounts));
    }

    @Test
    public void shouldReturnFalseForStraightIfStraightNotThrown(){
        diceCounts.put(1,3);
        diceCounts.put(2,3);

        assertFalse(Result.STRAIGHT.isResult(diceCounts));
    }
}