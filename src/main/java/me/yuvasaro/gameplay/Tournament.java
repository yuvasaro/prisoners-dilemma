package me.yuvasaro.gameplay;

import me.yuvasaro.strategies.*;

import java.util.*;

public class Tournament {
    private Strategy[] strategies;
    private HashMap<String, Integer> strategyScores;

    public Tournament() {
        strategies = new Strategy[]{
            new AlwaysCooperateStrategy(),
            new AlwaysDefectStrategy(),
            new FriedmanStrategy(),
            new GenerousTitForTatStrategy(),
            new GraaskampStrategy(),
            new JossStrategy(),
            new RandomStrategy(),
            new SampleStrategy(),
            new TesterStrategy(),
            new TitForTatStrategy()
        };

        strategyScores = new HashMap<>();
        for (Strategy strategy : strategies) {
            strategyScores.put(strategy.getName(), 0);
        }
    }

    public void playout() {
        for (Strategy s1 : strategies) {
            for (Strategy s2 : strategies) {
                // Avoid strategies playing themselves (TODO: create copy of strategy to play against self)
                if (s1 == s2) continue;

                Match match = new Match(s1, s2);
                int numRounds = 150 + (int)(Math.random() * 100);
                match.play(numRounds);

                int s1Score = match.getS1Score();
                int s2Score = match.getS2Score();
                strategyScores.put(s1.getName(), strategyScores.get(s1.getName()) + s1Score);
                strategyScores.put(s2.getName(), strategyScores.get(s2.getName()) + s2Score);
            }
        }

        HashMap<String, Integer> leaderboard = sortByHighestPoints(strategyScores);
        System.out.println("===== LEADERBOARD =====");
        for (Map.Entry<String, Integer> strategyScore : leaderboard.entrySet()) {
            System.out.printf("%s: %d%n", strategyScore.getKey(), strategyScore.getValue());
        }
    }

    private static HashMap<String, Integer> sortByHighestPoints(HashMap<String, Integer> hm) {
        List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(hm.entrySet());

        list.sort((o1, o2) -> (o1.getValue()).compareTo(o2.getValue()));
        Collections.reverse(list);

        HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }
}
