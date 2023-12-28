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

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GroupOutputWriterTest {
    ByteArrayOutputStream outContent;

    GroupOutputWriter groupOutputWriter;
    @BeforeEach
    void initOutputTestEnvironment() {
        outContent = new ByteArrayOutputStream();
    }

    String formatStringSymbols(String str) {

        return str.substring(0, str.length() - 2).replaceAll("\\n", "#").replaceAll("\\t", " ");
    }

    List<String> mapOutputToList(String output) {
        return Arrays.stream(formatStringSymbols(output).split("#")).toList();
    }

    @Test
    void testT() throws IOException {
        groupOutputWriter = new GroupOutputWriter(new OutputStreamWriter(outContent));

        groupOutputWriter.save(new MappedGroup(
                List.of(new Group("G1",List.of("C1"))),
                Map.of("C1", new GroupCalcRes(1, 0, 1, 0, 0, 0))));

        assertEquals("G1#C1 1 0 1 0 0 0", formatStringSymbols(outContent.toString()));
    }
}
