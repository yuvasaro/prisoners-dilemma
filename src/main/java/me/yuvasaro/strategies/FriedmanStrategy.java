package me.yuvasaro.strategies;

import java.util.ArrayList;

public class FriedmanStrategy extends Strategy {
    private boolean grudge = false;

    public FriedmanStrategy() {
        super("Friedman");
    }

    @Override
    public int move(ArrayList<Integer> oppMoveHist, int round) {
        // Start by cooperating
        // If the opponent defects once, keep defecting for the rest of the game
        if (oppMoveHist.size() == 0) {
            return Move.COOPERATE;
        }
        if (grudge) {
            return Move.DEFECT;
        }
        if (oppMoveHist.get(oppMoveHist.size() - 1) == Move.DEFECT) {
            grudge = true;
            return Move.DEFECT;
        }
        return Move.COOPERATE;
    }
}
