package com.greed;

import com.greed.scorer.*;
import com.greed.service.DiceCounter;
import com.greed.service.ScorersListCreator;

import java.util.ArrayList;
import java.util.Map;

public class Greed {

    private static final int MAXIMUM_DICE = 6;

    private final DiceCounter diceCounter;

    private final ScorersListCreator scorersListCreator;

    private int score = 0;

    public Greed(ScorersListCreator scorersListCreator, DiceCounter diceCounter) {

        this.scorersListCreator = scorersListCreator;
        this.diceCounter = diceCounter;
    }

    public int score(String[] dice) {

        if (dice.length > MAXIMUM_DICE) {
            throw new IllegalArgumentException("Only 6 dice allowed!");
        }

        Map<Integer, Integer> diceCounts = diceCounter.count(dice);

        ArrayList<Scorer> scorerArrayList = scorersListCreator.createList();

        for (Scorer scorer : scorerArrayList) {
            score += scorer.score(diceCounts);
        }

        subtractDuplicateScores(diceCounts);

        return score;
    }

    private void subtractDuplicateScores(Map<Integer,Integer>diceCounts){
        if (isThreePairs(diceCounts)||isStraight(diceCounts)){
            subtractScoreForSingleOnesAndFives(diceCounts);
        }
    }

    private void subtractScoreForSingleOnesAndFives(Map<Integer, Integer> diceCounts) {
        if (diceCounts.get(1) > 0){
            int scoreForSingleOne = 100;
            score -= diceCounts.get(1) * scoreForSingleOne;
        }
        if (diceCounts.get(5) > 0){
            int scoreForSingleFive = 50;
            score -= diceCounts.get(1) * scoreForSingleFive;
        }
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
