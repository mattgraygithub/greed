package com.greed;

import com.greed.result.Result;
import com.greed.scorer.Scorer;
import com.greed.service.DiceCounter;

import java.util.List;
import java.util.Map;

public class Greed {

    private static final int MAXIMUM_DICE = 6;

    private final DiceCounter diceCounter;

    private final List<Scorer> scorers;

    public Greed(List<Scorer> scorers, DiceCounter diceCounter) {

        this.diceCounter = diceCounter;
        this.scorers = scorers;
    }

    public int score(String[] dice) {

        int score = 0;

        if (dice.length > MAXIMUM_DICE) {
            throw new IllegalArgumentException("Only 6 dice allowed!");
        }

        Map<Integer, Integer> diceCounts = diceCounter.count(dice);

        for (Scorer scorer : scorers) {
            score += scorer.score(diceCounts);
        }

        return (Result.THREE_PAIRS.isResult(diceCounts) || Result.STRAIGHT.isResult(diceCounts))
                ? score - scoreForSingleOnes(diceCounts) - scoreForSingleFives(diceCounts)
                : score;
    }

    private int scoreForSingleOnes(Map<Integer, Integer> diceCounts) {
        if (diceCounts.get(1) > 0) {
            return diceCounts.get(1) * 100;
        } else {
            return 0;
        }
    }

    private int scoreForSingleFives(Map<Integer, Integer> diceCounts) {
        if (diceCounts.get(5) > 0) {
            return diceCounts.get(5) * 50;
        } else {
            return 0;
        }
    }
}
