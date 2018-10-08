package com.greed.scorer;

import com.greed.result.Result;

import java.util.Map;

public class StraightScorer implements Scorer {

    private static final int SCORE_FOR_STRAIGHT = 1200;
    private static final int NO_SCORE = 0;

    @Override
    public int score(Map<Integer, Integer> diceCounts) {
        return Result.STRAIGHT.isResult(diceCounts)
                ? SCORE_FOR_STRAIGHT
                : NO_SCORE;
    }
}
