package me.yuvasaro;

import me.yuvasaro.gameplay.Tournament;

public class Main {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();
        tournament.playout();
        tournament.printLeaderboard();
    }
}
