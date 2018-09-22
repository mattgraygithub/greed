package com.greed.scorer;

import java.util.Map;

public class ThreePairsScorer implements Scorer {

    private int scoreForThreePairs;

    @Override
    public int score(Map<Integer, Integer> diceCounts) {

        if (isThreePairs(diceCounts)) {
            scoreForThreePairs = 800;
        }

        return scoreForThreePairs;
    }

    private boolean isThreePairs(Map<Integer, Integer> diceCounts) {
        int numberOfPairs = 0;
        for (Integer die : diceCounts.keySet()) {
            int numberOfEachDie = diceCounts.get(die);
            if (numberOfEachDie == 2) {
                numberOfPairs++;
            }
        }
        return numberOfPairs == 3;
    }
}
