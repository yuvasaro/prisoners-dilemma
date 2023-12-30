package me.yuvasaro.strategies;

import java.util.ArrayList;

public class RandomStrategy extends Strategy {
    public RandomStrategy() {
        super("Random");
    }

    @Override
    public int move(ArrayList<Integer> oppMoveHist, int round) {
        // Randomly cooperate or defect 50% of the time
        if (Math.random() < 0.5) {
            return Move.DEFECT;
        }
        return Move.COOPERATE;
    }
}
