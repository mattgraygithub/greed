package com.greed.result;

import java.util.Map;
import java.util.function.Function;

public enum Result {

    THREE_PAIRS((Map<Integer, Integer> diceCounts) -> diceCounts.values().stream().filter(a -> a == 2).count() == 3),
    STRAIGHT ((Map<Integer, Integer> diceCounts) -> diceCounts.values().stream().filter(a -> a == 1).count() == 6);

    private final Function<Map<Integer, Integer>, Boolean> function;

    Result(Function<Map<Integer, Integer>, Boolean> function) {
        this.function = function;
    }

    public boolean isResult(Map<Integer, Integer> diceCounts){
        return function.apply(diceCounts);
    }
}


