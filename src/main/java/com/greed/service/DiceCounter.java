package com.greed.service;

import java.util.HashMap;
import java.util.Map;

public class DiceCounter {

    private static final int MAXIMUM_DICE = 6;

    public Map<Integer, Integer> count(String[] dice) {
        Map<Integer, Integer> diceCounts = new HashMap<>();
        for (int possibleDie = 1; possibleDie <= MAXIMUM_DICE; possibleDie++) {
            diceCounts.put(possibleDie, 0);
        }
        for (String die : dice) {
            diceCounts.computeIfPresent(Integer.valueOf(die), (key, value) -> ++value);
        }
        return diceCounts;
    }
}
