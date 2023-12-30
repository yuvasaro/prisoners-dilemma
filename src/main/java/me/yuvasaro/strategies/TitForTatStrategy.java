package me.yuvasaro.strategies;

import java.util.ArrayList;

public class TitForTatStrategy extends Strategy {
    public TitForTatStrategy() {
        super("Tit For Tat");
    }

    @Override
    public int move(ArrayList<Integer> oppMoveHist, int round) {
        // Copy opponent's last move
        if (oppMoveHist.size() == 0) {
            return Move.COOPERATE;
        }
        return oppMoveHist.get(oppMoveHist.size() - 1);
    }
}
