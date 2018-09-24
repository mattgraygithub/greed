package com.greed.scorer;

import com.greed.result.Result;

import java.util.Map;

public class ThreePairsScorer implements Scorer {

    private static final int SCORE_FOR_THREE_PAIRS= 800;
    private static final int NO_SCORE = 0;

    @Override
    public int score(Map<Integer, Integer> diceCounts) {
        return Result.THREE_PAIRS.isResult(diceCounts)
                ? SCORE_FOR_THREE_PAIRS
                : NO_SCORE;
    }
}
