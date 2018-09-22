package com.greed.scorer;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class OnesScorerTest {

    private static final int ONE_ONE = 1;
    private static final int THREE_ONES = 3;
    private static final int FOUR_ONES = 4;
    private static final int FIVE_ONES = 5;
    private static final int SIX_ONES = 6;

    private OnesScorer onesScorer = new OnesScorer();

    private Map<Integer, Integer> diceCounts = new HashMap<>();

    @Test
    public void shouldScoreOneHundredForEachOneThrown() {

        assertThat(scoreFor(ONE_ONE), is(100));
    }

    @Test
    public void shouldScoreOneThousandForTripleOnes() {

        assertThat(scoreFor(THREE_ONES), is(1000));
    }

    @Test
    public void shouldScoreTripleScoreMultipliedByTwoForFourOfAKind() {

        assertThat(scoreFor(FOUR_ONES), is(2000));
    }

    @Test
    public void shouldScoreTripleScoreMultipliedByFourForFiveOfAKind() {

        assertThat(scoreFor(FIVE_ONES), is(4000));
    }

    @Test
    public void shouldScoreTripleScoreMultipliedByEightForSixOfAKind() {

        assertThat(scoreFor(SIX_ONES), is(8000));
    }

    private int scoreFor(int numberOfOnesThrown) {

        diceCounts.put(1, numberOfOnesThrown);
        return onesScorer.score(diceCounts);
    }
}