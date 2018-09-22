package com.greed.service;

import com.greed.scorer.*;

import java.util.ArrayList;

public class ScorersListCreator {

    private ArrayList<Scorer> scorersList = new ArrayList<>();

    public ArrayList<Scorer> createList() {

        scorersList.add(new OnesScorer());
        scorersList.add(new FivesScorer());
        scorersList.add(new TriplesAndUpwardsScorer());
        scorersList.add(new ThreePairsScorer());
        scorersList.add(new StraightScorer());

        return scorersList;
    }
}
