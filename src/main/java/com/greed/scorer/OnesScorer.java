package com.greed.scorer;

import java.util.Map;

public class OnesScorer implements Scorer {

    private static final int NUMBER_OF_ONES = 1;
    private static final int SCORE_FOR_SINGLE_ONE = 100;
    private static final int SCORE_FOR_TRIPLE_ONE = 1000;
    private static final int NO_SCORE = 0;

    @Override
    public int score(Map<Integer, Integer> diceCounts) {

        int numberOfOnes = diceCounts.get(NUMBER_OF_ONES);

        if (numberOfOnes > 0 && numberOfOnes <= 2) {
            return numberOfOnes * SCORE_FOR_SINGLE_ONE;
        } else if (numberOfOnes >= 3) {
            return (int) (SCORE_FOR_TRIPLE_ONE * (Math.pow(2, numberOfOnes - 3)));
        }
        return NO_SCORE;
    }
}
