package me.yuvasaro.strategies;

import java.util.ArrayList;

public class AlwaysDefectStrategy extends Strategy{
    public AlwaysDefectStrategy() {
        super("Always Defect");
    }

    @Override
    public int move(ArrayList<Integer> oppMoveHist, int round) {
        // Always defect
        return Move.DEFECT;
    }
}
