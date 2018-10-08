package com.greed.scorer;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class FivesScorerTest {

    private static final int ONE_FIVE_THROWN = 1;

    private FivesScorer fivesScorer = new FivesScorer();

    private Map<Integer, Integer> diceCounts = new HashMap<>();

    @Test
    public void shouldScoreFiftyForEachFiveThrown() {

        diceCounts.put(5, ONE_FIVE_THROWN);

        assertThat(fivesScorer.score(diceCounts), is(50));
    }
}
