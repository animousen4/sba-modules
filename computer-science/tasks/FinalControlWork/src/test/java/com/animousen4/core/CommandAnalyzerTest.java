package com.animousen4.core;

import com.animousen4.core.CommandAnalyzer;
import com.animousen4.core.entites.GroupCalcRes;
import com.animousen4.core.entites.Match;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

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

        /*
        Assertions.assertThat(actual).containsExactlyInAnyOrderEntriesOf(
                Map.of("Key1", "Value1", "Key2", "Value2")
        );
        * */
       /* assertThat(res.get("C1")).usingRecursiveAssertion().isEqualTo(expected.get("C1"));
        assertThat(res.get("C2")).usingRecursiveAssertion().isEqualTo(expected.get("C2"));*/

    }
}
