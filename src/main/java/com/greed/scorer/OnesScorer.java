package com.greed.scorer;

import java.util.Map;

public class OnesScorer implements Scorer {

    private static final int NUMBER_OF_ONES = 1;
    private static final int SCORE_FOR_SINGLE_ONE = 100;
    private static final int SCORE_FOR_TRIPLE_ONE = 1000;

    private int scoreForOnes;

    @Override
    public int score(Map<Integer, Integer> diceCounts) {

        int numberOfOnes = diceCounts.get(NUMBER_OF_ONES);

        if (numberOfOnes <= 2) {
            scoreForOnes += numberOfOnes * SCORE_FOR_SINGLE_ONE;
        }
        if (numberOfOnes >= 3) {
            scoreForOnes += SCORE_FOR_TRIPLE_ONE * (Math.pow(2, numberOfOnes - 3));
        }
        return scoreForOnes;
    }
}
