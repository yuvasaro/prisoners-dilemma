package me.yuvasaro.strategies;

import java.util.ArrayList;

public class JossStrategy extends Strategy {
    public JossStrategy() {
        super("Joss");
    }

    @Override
    public int move(ArrayList<Integer> oppMoveHist, int round) {
        // Copy opponent's last move
        // Defect 10% of the time (sneaky)
        if (oppMoveHist.size() == 0) {
            return Move.COOPERATE;
        }
        if (Math.random() < 0.1) {
            return Move.DEFECT;
        }
        return oppMoveHist.get(oppMoveHist.size() - 1);
    }
}
