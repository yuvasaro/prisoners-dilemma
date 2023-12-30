package me.yuvasaro.gameplay;

import me.yuvasaro.strategies.Move;
import me.yuvasaro.strategies.Strategy;

import java.util.ArrayList;

public class Match {
    private static int BOTH_COOPERATE_SCORE = 3;
    private static int DEFECT_WIN_SCORE = 5;
    // private static int DEFECT_LOSS_SCORE = 0;
    private static int BOTH_DEFECT_SCORE = 1;

    private Strategy s1;
    private Strategy s2;
    private ArrayList<Integer> s1MoveHist;
    private ArrayList<Integer> s2MoveHist;
    private int s1Score;
    private int s2Score;
    private Strategy winner;
    private boolean draw;

    public Match(Strategy s1, Strategy s2) {
        this.s1 = s1;
        this.s2 = s2;
        s1MoveHist = new ArrayList<>();
        s2MoveHist = new ArrayList<>();
        s1Score = 0;
        s2Score = 0;
        winner = null;
        draw = false;
    }

    public void play(int numRounds) {
        for (int i = 1; i <= numRounds; i++) {
            int s1Move = s1.move(s2MoveHist, i);
            int s2Move = s2.move(s1MoveHist, i);
            s1MoveHist.add(s1Move);
            s2MoveHist.add(s2Move);
            addScores(s1Move, s2Move);
        }

        // If it's a draw, set draw = true and winner = null
        draw = (s1Score == s2Score);

        // Set winner to the winning strategy
        if (!draw) {
            if (s1Score > s2Score) {
                winner = s1;
            } else {
                winner = s2;
            }
        }
    }

    public void addScores(int s1Move, int s2Move) {
        if ((s1Move == Move.COOPERATE && s2Move == Move.COOPERATE)) {
            s1Score += BOTH_COOPERATE_SCORE;
            s2Score += BOTH_COOPERATE_SCORE;
        } else if ((s1Move == Move.DEFECT) && (s2Move == Move.COOPERATE)) {
            s1Score += DEFECT_WIN_SCORE;
        } else if ((s1Move == Move.COOPERATE) && (s2Move == Move.DEFECT)) {
            s2Score += DEFECT_WIN_SCORE;
        } else if ((s1Move == Move.DEFECT) && (s2Move == Move.DEFECT)) {
            s1Score += BOTH_DEFECT_SCORE;
            s2Score += BOTH_DEFECT_SCORE;
        }
    }

    public Strategy getS1() {
        return s1;
    }

    public Strategy getS2() {
        return s2;
    }

    public int getS1Score() {
        return s1Score;
    }

    public int getS2Score() {
        return s2Score;
    }

    public Strategy getWinner() {
        return winner;
    }

    public boolean isDraw() {
        return draw;
    }
}
