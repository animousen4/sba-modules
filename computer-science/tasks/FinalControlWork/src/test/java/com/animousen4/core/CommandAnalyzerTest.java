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


        assertThat(res.get("C1")).usingRecursiveComparison().isEqualTo(expected.get("C1"));
        assertThat(res.get("C2")).usingRecursiveComparison().isEqualTo(expected.get("C2"));

        assertEquals(2, res.size());



    }
}
