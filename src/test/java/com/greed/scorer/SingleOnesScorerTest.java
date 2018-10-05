package com.greed.scorer;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class SingleOnesScorerTest {

    private SingleOnesScorer singleOnesScorer = new SingleOnesScorer();

    private Map<Integer, Integer> diceCounts = new HashMap<>();

    @Test
    public void shouldSubtractScoreForEachSingleOneIfThreePairsThrown(){

        for (int die = 1; die <= 6; die += 2) {
            diceCounts.put(die, 2);
        }

        assertThat(singleOnesScorer.score(diceCounts),is(-200));
    }

    @Test
    public void shouldSubtractScoreForEachSingleOneIfStraightThrown(){

        for (int die = 1; die <= 6; die++) {
            diceCounts.put(die, 1);
        }

        assertThat(singleOnesScorer.score(diceCounts),is(-100));
    }
}
