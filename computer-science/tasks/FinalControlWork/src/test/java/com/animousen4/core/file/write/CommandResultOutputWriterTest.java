package com.animousen4.core.file.write;

import com.animousen4.core.entites.Group;
import com.animousen4.core.entites.GroupCalcRes;
import com.animousen4.core.entites.MappedGroup;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommandResultOutputWriterTest {

    ByteArrayOutputStream outContent;

    CommandResultOutputWriter commandResultOutputWriter;

    @BeforeEach
    void initOutputTestEnvironment() {
        outContent = new ByteArrayOutputStream();
    }

    String formatStringSymbols(String str) {

        return str.substring(0, str.length() - 1).replaceAll("\\n", "#").replaceAll("\\t", " ");
    }

    List<String> mapOutputToList(String output) {
        return Arrays.stream(formatStringSymbols(output).split("#")).toList();
    }
    @Test
    public void testOutputFileOneGroup() throws IOException {
        commandResultOutputWriter = new CommandResultOutputWriter(new OutputStreamWriter(outContent));
        commandResultOutputWriter.save(new MappedGroup(
                List.of(new Group("G1",List.of("C1"))),
                Map.of("C1", new GroupCalcRes(1, 0, 1, 0, 0, 0))));
        String expectedOutput = "C1 1 1";
        assertEquals(expectedOutput, formatStringSymbols(outContent.toString()));
    }

    @Test
    public void testOutputFileTwoCommands() throws IOException {
        commandResultOutputWriter = new CommandResultOutputWriter(new OutputStreamWriter(outContent));
        commandResultOutputWriter.save(new MappedGroup(
                List.of(new Group("G1",List.of("C1"))),
                Map.of(
                        "C1",
                        new GroupCalcRes(5, 1, 1, 1, 0, 0),
                        "C2",
                        new GroupCalcRes(5, 1, 1, 1, 0, 0)
                )));
        List<String> expectedOutput = List.of("C1 5 3", "C2 5 3");
        List<String> realOutput = Arrays.stream(formatStringSymbols(outContent.toString()).split("#")).toList();
        assertThat(realOutput).containsExactlyInAnyOrderElementsOf(expectedOutput);
    }

    @Test
    public void testOutputFileThreeCommands() throws IOException {
        commandResultOutputWriter = new CommandResultOutputWriter(new OutputStreamWriter(outContent));
        commandResultOutputWriter.save(new MappedGroup(
                List.of(new Group("G1",List.of("C1"))),
                Map.of(
                        "C1",
                        new GroupCalcRes(5, 1, 1, 1, 0, 0),
                        "C2",
                        new GroupCalcRes(5, 1, 1, 1, 0, 0),
                        "C3",
                        new GroupCalcRes(5, 1, 1, 1, 0, 0)
                )));
        List<String> expectedOutput = List.of("C1 5 3", "C2 5 3", "C3 5 3");
        List<String> realOutput = mapOutputToList(outContent.toString());
        assertThat(realOutput).containsExactlyInAnyOrderElementsOf(expectedOutput);
    }

}
