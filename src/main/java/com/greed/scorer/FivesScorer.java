package com.greed.scorer;

import java.util.Map;

public class FivesScorer implements Scorer {

    private static final int NUMBER_OF_FIVES = 5;
    private static final int SCORE_FOR_SINGLE_FIVE = 50;

    private int scoreForFives;

    @Override
    public int score(Map<Integer, Integer> diceCounts) {

        int numberOfFives = diceCounts.get(NUMBER_OF_FIVES);

        if (numberOfFives <= 2) {
            scoreForFives += numberOfFives * SCORE_FOR_SINGLE_FIVE;
        }
        return scoreForFives;
    }
}
