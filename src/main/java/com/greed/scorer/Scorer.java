package com.greed.scorer;

import java.util.Map;

public interface Scorer {

    int score(Map<Integer, Integer> diceCounts);
}

