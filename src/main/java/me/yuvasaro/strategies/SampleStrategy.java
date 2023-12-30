package me.yuvasaro.strategies;

import java.util.ArrayList;

public class SampleStrategy extends Strategy {
    public SampleStrategy() {
        super("Sample");
    }

    @Override
    public int move(ArrayList<Integer> oppMoveHist, int round) {
        // Only defect if the opponent has defected twice in a row, otherwise cooperate
        if (oppMoveHist.size() == 0 || oppMoveHist.size() == 1) {
            return Move.COOPERATE;
        }
        if (oppMoveHist.get(oppMoveHist.size() - 1) == Move.DEFECT && oppMoveHist.get(oppMoveHist.size() - 2) == Move.DEFECT) {
            return Move.DEFECT;
        }
        return Move.COOPERATE;
    }
}
