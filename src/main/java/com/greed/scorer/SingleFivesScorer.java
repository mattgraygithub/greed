package com.greed.scorer;

import com.greed.result.Result;

import java.util.Map;

public class SingleFivesScorer implements Scorer {

    private static final int SCORE_FOR_SINGLE_FIVE = 50;

    @Override
    public int score(Map<Integer, Integer> diceCounts){

        int numberOfFives = diceCounts.get(5);

        return (Result.THREE_PAIRS.isResult(diceCounts)||
                Result.STRAIGHT.isResult(diceCounts))
                && numberOfFives > 0
                ? - numberOfFives * SCORE_FOR_SINGLE_FIVE
                : 0;
    }
}