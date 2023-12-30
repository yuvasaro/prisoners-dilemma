package me.yuvasaro.strategies;

import java.util.ArrayList;

public abstract class Strategy {
    private final String name;

    public Strategy(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract int move(ArrayList<Integer> oppMoveHist, int round);
}
