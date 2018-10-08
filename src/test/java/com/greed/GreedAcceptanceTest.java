package com.greed;

import com.greed.scorer.*;
import com.greed.service.DiceCounter;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class GreedAcceptanceTest {

    private DiceCounter diceCounter = new DiceCounter();

    private final List<Scorer> scorers = Arrays.asList(
            new OnesScorer(),
            new FivesScorer(),
            new TriplesAndUpwardsScorer(),
            new ThreePairsScorer(),
            new StraightScorer(),
            new SingleOnesScorer(),
            new SingleFivesScorer()
    );

    private Greed greed = new Greed(scorers, diceCounter);

    @Test
    public void shouldScoreFourHundredAndFiftyForTwoOnesOneFiveAndThreeTwos() {
        assertThat(score("1", "5", "1", "2", "2", "2"), is(450));
    }

    @Test
    public void shouldScoreEightHundredForThreePairs() {
        assertThat(score("1", "1", "2", "2", "5", "5"), is(800));
    }

    @Test
    public void shouldScoreOneThousandTwoHundredForStraight() {
        assertThat(score("6", "5", "4", "3", "2", "1"), is(1200));
    }

    private int score(String one, String two, String three, String four, String five, String six) {
        return greed.score(new String[]{one, two, three, four, five, six});
    }
}
