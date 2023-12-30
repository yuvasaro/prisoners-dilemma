package me.yuvasaro.strategies;

import java.util.ArrayList;

public class GraaskampStrategy extends Strategy {
    public GraaskampStrategy() {
        super("Graaskamp");
    }

    @Override
    public int move(ArrayList<Integer> oppMoveHist, int round) {
        // Copy opponent's last move
        // Defect in intervals of 50 rounds
        if (oppMoveHist.size() == 0) {
            return Move.COOPERATE;
        }
        if (round % 50 == 0) {
            return Move.DEFECT;
        }
        return oppMoveHist.get(oppMoveHist.size() - 1);
    }
}
