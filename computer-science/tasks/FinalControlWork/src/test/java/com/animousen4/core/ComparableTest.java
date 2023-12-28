package com.animousen4.core;

import com.animousen4.core.entites.GroupCalcRes;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComparableTest {

    @Test
    void compareGroupInstances() {
        GroupCalcRes gcrOne = new GroupCalcRes(
                1, 1, 1, 1, 1, 1
        );

        GroupCalcRes gcrTwo = new GroupCalcRes(
                1, 1, 1, 1, 1, 1
        );

        assertEquals(gcrOne, gcrTwo);
    }
}
