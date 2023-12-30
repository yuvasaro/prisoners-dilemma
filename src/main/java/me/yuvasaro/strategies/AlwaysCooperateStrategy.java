package me.yuvasaro.strategies;

import java.util.ArrayList;

public class AlwaysCooperateStrategy extends Strategy {
    public AlwaysCooperateStrategy() {
        super("Always Cooperate");
    }

    @Override
    public int move(ArrayList<Integer> oppMoveHist, int round) {
        // Always cooperate
        return Move.COOPERATE;
    }
}
