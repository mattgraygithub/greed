package com.greed.scorer;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class TriplesAndUpwardsScorerTest {

    private static final int THREE = 3;
    private static final int FOUR = 4;
    private static final int FIVE = 5;
    private static final int SIX = 6;
    private static final int TWOS = 2;
    private static final int THREES = 3;
    private static final int FOURS = 4;
    private static final int FIVES = 5;
    private static final int SIXES = 6;


    private Map<Integer, Integer> diceCounts = new HashMap<>();

    private TriplesAndUpwardsScorer triplesAndUpwardsScorer = new TriplesAndUpwardsScorer();

    @Test
    public void shouldScoreDieValueMultipliedByOneHundredForTripleTwos() {

        assertThat(scoreFor(THREE, TWOS), is(200));
    }

    @Test
    public void shouldScoreDieValueMultipliedByOneHundredForTripleThrees() {

        assertThat(scoreFor(THREE, THREES), is(300));
    }

    @Test
    public void shouldScoreDieValueMultipliedByOneHundredForTripleFours() {

        assertThat(scoreFor(THREE, FOURS), is(400));
    }

    @Test
    public void shouldScoreDieValueMultipliedByOneHundredForTripleFives() {

        assertThat(scoreFor(THREE, FIVES), is(500));
    }

    @Test
    public void shouldScoreDieValueMultipliedByOneHundredForTripleSixes() {

        assertThat(scoreFor(THREE, SIXES), is(600));
    }

    @Test
    public void shouldScoreTripleScoreMultipliedByTwoForFourOfAKind() {

        assertThat(scoreFor(FOUR, TWOS), is(400));
    }

    @Test
    public void shouldScoreTripleScoreMultipliedByFourForFiveOfAKind() {

        assertThat(scoreFor(FIVE, FOURS), is(1600));
    }

    @Test
    public void shouldScoreTripleScoreMultipliedByEightForSixOfAKind() {

        assertThat(scoreFor(SIX, SIXES), is(4800));
    }

    private int scoreFor(int numberOfDiceThrown, int dieValue) {

        diceCounts.put(dieValue, numberOfDiceThrown);
        return triplesAndUpwardsScorer.score(diceCounts);
    }
}
