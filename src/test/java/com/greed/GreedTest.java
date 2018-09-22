package com.greed;

import com.greed.scorer.*;
import com.greed.service.DiceCounter;
import com.greed.service.ScorersListCreator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class GreedTest {

    private static final Map<Integer, Integer> DICE_COUNTS = new HashMap<Integer, Integer>(){{
        put(1, 1);
        put(2, 5);
        put(3, 6);
        put(4, 6);
        put(5, 6);
        put(6, 0);
    }};

    private static final ArrayList<Scorer> scorersList = new ArrayList<>();

    @Mock
    private DiceCounter diceCounter;

    @Mock
    private OnesScorer onesScorer;

    @Mock
    private FivesScorer fivesScorer;

    @Mock
    private TriplesAndUpwardsScorer triplesAndUpwardsScorer;

    @Mock
    private ThreePairsScorer threePairsScorer;

    @Mock
    private StraightScorer straightScorer;

    @Mock
    private ScorersListCreator scorersListCreator;

    @InjectMocks
    private Greed greed;

    @Test(expected = IllegalArgumentException.class)
    public void shouldOnlyAcceptUpToSixDiceThrown() {
        greed.score(new String[]{"1", "2", "3", "4", "5", "6", "7"});
    }

    @Test
    public void shouldAddScorersTogetherToGiveFinalScore() {

        when(diceCounter.count(new String[]{"1", "5", "6", "6", "6", "0"})).thenReturn(DICE_COUNTS);
        when(onesScorer.score(DICE_COUNTS)).thenReturn(100);
        when(fivesScorer.score(DICE_COUNTS)).thenReturn(50);
        when(triplesAndUpwardsScorer.score(DICE_COUNTS)).thenReturn(600);
        when(threePairsScorer.score(DICE_COUNTS)).thenReturn(0);
        when(straightScorer.score(DICE_COUNTS)).thenReturn(0);
        when(scorersListCreator.createList()).thenReturn(createList());

        assertThat(greed.score(new String[]{"1", "5", "6", "6", "6", "0"}), is(750));
    }

    private ArrayList<Scorer> createList() {

        scorersList.add(onesScorer);
        scorersList.add(fivesScorer);
        scorersList.add(triplesAndUpwardsScorer);
        scorersList.add(threePairsScorer);
        scorersList.add(straightScorer);

        return scorersList;
    }
}