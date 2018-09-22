package com.greed.scorer;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ThreePairsScorerTest {

    private static final int TWO_ONES_TWO_THREES_AND_TWO_FIVES = 1;
    private static final int TWO_TWOS_TWO_FOURS_AND_TWO_SIXES = 2;

    private Map<Integer, Integer> diceCounts = new HashMap<>();

    private ThreePairsScorer threePairsScorer = new ThreePairsScorer();

    @Test
    public void shouldScoreEightHundredForDoubleOnesDoublesThreesAndDoubleFives() {

        assertThat(scoreFor(TWO_ONES_TWO_THREES_AND_TWO_FIVES), is(800));
    }

    @Test
    public void shouldScoreEightHundredDoubleTwosDoubleFoursAndDoubleSixes() {

        assertThat(scoreFor(TWO_TWOS_TWO_FOURS_AND_TWO_SIXES), is(800));
    }

    private int scoreFor(int startingDie) {

        for (int die = startingDie; die <= 6; die += 2) {
            diceCounts.put(die, 2);
        }
        return threePairsScorer.score(diceCounts);
    }
}