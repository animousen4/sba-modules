package com.animousen4.core;

import com.animousen4.core.CommandAnalyzer;
import com.animousen4.core.entites.GroupCalcRes;
import com.animousen4.core.entites.Match;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CommandAnalyzerTest {

    CommandAnalyzer commandAnalyzer;

    @Test
    void testDrawCalculation() {
        commandAnalyzer = new CommandAnalyzer();
        Map<String, GroupCalcRes> res = commandAnalyzer.getCalculatedMaps(
                new ArrayList<>(
                        List.of(new Match(
                                "C1",
                                1,
                                "C2",
                                1
                        ))
                )
        );

        var commandResult = GroupCalcRes.builder()
                .points(2)
                .draws(1)
                .scored(1)
                .missed(1)
                .build();


        Map<String, GroupCalcRes> expected = new LinkedHashMap<>(Map.of(
                "C1", commandResult, "C2", commandResult
        ));

        assertEquals(2, res.size());

        assertThat(res).containsExactlyInAnyOrderEntriesOf(expected);

    }

    @Test
    void testZeroDrawCalculation() {
        commandAnalyzer = new CommandAnalyzer();
        Map<String, GroupCalcRes> res = commandAnalyzer.getCalculatedMaps(
                new ArrayList<>(
                        List.of(new Match(
                                "C1",
                                0,
                                "C2",
                                0
                        ))
                )
        );

        var commandResult = GroupCalcRes.builder()
                .points(2)
                .draws(1)
                .scored(0)
                .missed(0)
                .build();


        Map<String, GroupCalcRes> expected = new LinkedHashMap<>(Map.of(
                "C1", commandResult, "C2", commandResult
        ));

        assertEquals(2, res.size());

        assertThat(res).containsExactlyInAnyOrderEntriesOf(expected);

    }

    @Test
    void testWinOneCalculation() {
        commandAnalyzer = new CommandAnalyzer();
        Map<String, GroupCalcRes> res = commandAnalyzer.getCalculatedMaps(
                new ArrayList<>(
                        List.of(new Match(
                                "C1",
                                3,
                                "C2",
                                1
                        ))
                )
        );

        var commandOneResult = GroupCalcRes.builder()
                .points(3)
                .wins(1)
                .scored(3)
                .missed(1)
                .build();

        var commandTwoResult = GroupCalcRes.builder()
                .points(1)
                .loses(1)
                .scored(1)
                .missed(3)
                .build();


        Map<String, GroupCalcRes> expected = new LinkedHashMap<>(Map.of(
                "C1", commandOneResult, "C2", commandTwoResult
        ));

        assertEquals(2, res.size());

        assertThat(res).containsExactlyInAnyOrderEntriesOf(expected);

    }

    @Test
    void testWinTwoCalculation() {
        commandAnalyzer = new CommandAnalyzer();
        Map<String, GroupCalcRes> res = commandAnalyzer.getCalculatedMaps(
                new ArrayList<>(
                        List.of(new Match(
                                "C1",
                                1,
                                "C2",
                                100
                        ))
                )
        );

        var commandOneResult = GroupCalcRes.builder()
                .points(1)
                .loses(1)
                .scored(1)
                .missed(100)
                .build();

        var commandTwoResult = GroupCalcRes.builder()
                .points(3)
                .wins(1)
                .scored(100)
                .missed(1)
                .build();


        Map<String, GroupCalcRes> expected = new LinkedHashMap<>(Map.of(
                "C1", commandOneResult, "C2", commandTwoResult
        ));

        assertEquals(2, res.size());

        assertThat(res).containsExactlyInAnyOrderEntriesOf(expected);

    }

    @Test
    void testSeveralAmountCalculation() {
        commandAnalyzer = new CommandAnalyzer();
        Map<String, GroupCalcRes> res = commandAnalyzer.getCalculatedMaps(
                new ArrayList<>(
                        List.of(
                                new Match(
                                "C1",
                                1,
                                "C2",
                                7),
                                new Match(
                                        "C2",
                                        5,
                                        "C3",
                                        3),
                                new Match(
                                        "C3",
                                        4,
                                        "C1",
                                        4)

                        )
                )
        );

        var commandOneResult = GroupCalcRes.builder()
                .points(3)
                .draws(1)
                .loses(1)
                .scored(5)
                .missed(11)
                .build();

        var commandTwoResult = GroupCalcRes.builder()
                .points(6)
                .wins(2)
                .scored(12)
                .missed(4)
                .build();

        var commandThreeResult = GroupCalcRes.builder()
                .points(3)
                .draws(1)
                .loses(1)
                .scored(7)
                .missed(9)
                .build();


        Map<String, GroupCalcRes> expected = new LinkedHashMap<>(Map.of(
                "C1", commandOneResult, "C2", commandTwoResult, "C3", commandThreeResult
        ));

        assertEquals(3, res.size());

        assertThat(res).containsExactlyInAnyOrderEntriesOf(expected);

    }



}
