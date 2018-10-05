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

        if (dice.length > MAXIMUM_DICE) {
            throw new IllegalArgumentException("Only 6 dice allowed!");
        }

        Map<Integer, Integer> diceCounts = diceCounter.count(dice);

        return scorers.stream().mapToInt(scorer -> scorer.score(diceCounts)).sum();
    }
}
