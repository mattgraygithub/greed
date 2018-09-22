package com.greed.scorer;

import java.util.Map;

public class StraightScorer implements Scorer {

    private int scoreForStraight;

    @Override
    public int score(Map<Integer, Integer> diceCounts) {

        if (isStraight(diceCounts)) {
            scoreForStraight = 1200;
        }
        return scoreForStraight;
    }

    private boolean isStraight(Map<Integer, Integer> diceCounts) {
        int valuesEqual = 0;
        for (Integer die : diceCounts.keySet()) {
            int numberOfEachDie = diceCounts.get(die);
            if (numberOfEachDie == 1) {
                valuesEqual++;
            }
        }
        return valuesEqual == diceCounts.size();
    }

}
