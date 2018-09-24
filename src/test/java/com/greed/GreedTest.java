package com.greed;

import com.greed.scorer.*;
import com.greed.service.DiceCounter;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class GreedTest {

    private static final Map<Integer, Integer> DICE_COUNTS = new HashMap<Integer, Integer>() {{
        put(1, 1);
        put(2, 5);
        put(3, 6);
        put(4, 6);
        put(5, 6);
        put(6, 0);
    }};

    @Mock
    private DiceCounter diceCounter;

    @Mock
    private Scorer scorer1;

    @Mock
    private Scorer scorer2;

    @Mock
    private Scorer scorer3;

    private final List<Scorer> scorers = new ArrayList<>();

    private Greed greed;

    @Before
    public void before() {
        scorers.add(scorer1);
        scorers.add(scorer2);
        scorers.add(scorer3);

        greed = new Greed(scorers, diceCounter);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldOnlyAcceptUpToSixDiceThrown() {
        greed.score(new String[]{"1", "2", "3", "4", "5", "6", "7"});
    }

    @Test
    public void shouldAddScorersTogetherToGiveFinalScore() {

        when(scorer1.score(DICE_COUNTS)).thenReturn(100);
        when(scorer2.score(DICE_COUNTS)).thenReturn(200);
        when(scorer3.score(DICE_COUNTS)).thenReturn(450);
        when(diceCounter.count(new String[]{"1", "5", "6", "6", "6", "0"})).thenReturn(DICE_COUNTS);

        assertThat(greed.score(new String[]{"1", "5", "6", "6", "6", "0"}), is(750));
    }
}
