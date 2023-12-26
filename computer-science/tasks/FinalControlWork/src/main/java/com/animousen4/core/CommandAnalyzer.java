package com.animousen4.core;

import com.animousen4.core.entites.Group;
import com.animousen4.core.entites.GroupCalcRes;
import com.animousen4.core.entites.Match;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommandAnalyzer {
    public Map<String, GroupCalcRes> getCalculatedMaps(List<Match> matches) {
        HashMap<String, GroupCalcRes> m = new HashMap<>();

        matches.forEach(
                match -> {

                    if (!m.containsKey(match.getCommandOne())) {
                        m.put(
                                match.getCommandOne(),
                                GroupCalcRes.builder()
                                        .points(0)
                                        .wins(0)
                                        .draws(0)
                                        .loses(0)
                                        .scored(0)
                                        .missed(0)
                                        .build());
                    }

                    if (!m.containsKey(match.getCommandTwo())) {
                        m.put(
                                match.getCommandTwo(),
                                GroupCalcRes.builder()
                                        .points(0)
                                        .wins(0)
                                        .draws(0)
                                        .loses(0)
                                        .scored(0)
                                        .missed(0)
                                        .build());
                    }
                    GroupCalcRes r1 = m.get(match.getCommandOne());
                    GroupCalcRes r2 = m.get(match.getCommandTwo());
                    if (match.isDraw()) {

                        r1.draws += 1;
                        r1.points += 2;

                        r2.draws += 1;
                        r2.points += 2;


                    } else if (match.winOne()) {
                        r1.wins += 1;
                        r1.points += 3;

                        r2.loses += 1;
                        r2.points += 1;
                    } else if (match.winTwo()) {
                        r1.loses += 1;
                        r1.points += 1;

                        r2.wins += 1;
                        r2.points += 3;
                    }

                    r1.scored += match.getGoalOne();
                    r1.missed += match.getGoalTwo();

                    r2.scored += match.getGoalTwo();
                    r2.missed += match.getGoalOne();


                    m.put(match.getCommandOne(), r1);
                    m.put(match.getCommandTwo(), r2);

                }
        );

        return m;
    }

}
