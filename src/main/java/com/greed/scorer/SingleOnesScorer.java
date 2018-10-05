package com.greed.scorer;

import com.greed.result.Result;

import java.util.Map;

public class SingleOnesScorer implements Scorer {

    private static final int SCORE_FOR_SINGLE_ONE = 100;

    @Override
    public int score(Map<Integer, Integer> diceCounts){

        int numberOfOnes = diceCounts.get(1);

        return (Result.THREE_PAIRS.isResult(diceCounts)||
                Result.STRAIGHT.isResult(diceCounts))
                && numberOfOnes > 0
                ? - numberOfOnes * SCORE_FOR_SINGLE_ONE
                : 0;
    }
}
