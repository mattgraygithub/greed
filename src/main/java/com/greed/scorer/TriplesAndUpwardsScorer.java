package com.greed.scorer;

import java.util.Map;

public class TriplesAndUpwardsScorer implements Scorer {

    private static final int SCORE_FOR_TRIPLES = 100;

    private int scoreForTriplesAndUpwards;

    @Override
    public int score(Map<Integer, Integer> diceCounts) {

        for (Integer die : diceCounts.keySet()) {
            int numberOfEachDieThrown = diceCounts.get(die);

            if (die > 1) {
                if (numberOfEachDieThrown >= 3) {
                    scoreForTriplesAndUpwards += die * SCORE_FOR_TRIPLES * (Math.pow(2, numberOfEachDieThrown - 3));
                }
            }
        }
        return scoreForTriplesAndUpwards;
    }
}
