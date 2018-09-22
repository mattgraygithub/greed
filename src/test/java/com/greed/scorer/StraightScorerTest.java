package com.greed.scorer;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class StraightScorerTest {

    private Map<Integer, Integer> diceCounts = new HashMap<>();

    private StraightScorer straightScorer = new StraightScorer();

    @Test
    public void shouldScoreOneThousandTwoHundredForStraight() {

        for (int die = 1; die <= 6; die++) {
            diceCounts.put(die, 1);
        }

        assertThat(straightScorer.score(diceCounts), is(1200));
    }
}