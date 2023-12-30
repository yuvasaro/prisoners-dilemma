package me.yuvasaro.strategies;

import java.util.ArrayList;

public class GenerousTitForTatStrategy extends Strategy {
    public GenerousTitForTatStrategy() {
        super("Generous Tit For Tat");
    }

    @Override
    public int move(ArrayList<Integer> oppMoveHist, int round) {
        // Tit For Tat, but retaliate only 9 out of 10 times
        if (oppMoveHist.size() == 0) {
            return Move.COOPERATE;
        }
        if (oppMoveHist.get(oppMoveHist.size() - 1) == Move.DEFECT) {
            if (Math.random() < 0.9) {
                return Move.DEFECT;
            } else {
                return Move.COOPERATE;
            }
        }
        return oppMoveHist.get(oppMoveHist.size() - 1);
    }
}
