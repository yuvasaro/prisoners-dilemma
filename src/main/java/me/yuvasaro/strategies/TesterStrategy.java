package me.yuvasaro.strategies;

import java.util.ArrayList;

public class TesterStrategy extends Strategy {
    private boolean oppRetaliated = false;

    public TesterStrategy() {
        super("Tester");
    }

    @Override
    public int move(ArrayList<Integer> oppMoveHist, int round) {
        // Defect on first round to see how opponent reacts
        // If opponent retaliates, "apologize" and play Tit For Tat the rest of the match
        // Otherwise, defect every other round
        if (oppMoveHist.size() == 0) {
            return Move.DEFECT;
        }
        if (oppMoveHist.size() == 1) {
            return Move.COOPERATE;
        }
        if (oppMoveHist.size() == 2) {
            oppRetaliated = (oppMoveHist.get(oppMoveHist.size() - 1) == Move.DEFECT);
            if (oppRetaliated) {
                return Move.COOPERATE;
            } else {
                return Move.DEFECT;
            }
        }
        if (oppRetaliated) {
            return oppMoveHist.get(oppMoveHist.size() - 1);
        } else {
            if (round % 2 == 1) {
                return Move.DEFECT;
            } else {
                return Move.COOPERATE;
            }
        }
    }
}
