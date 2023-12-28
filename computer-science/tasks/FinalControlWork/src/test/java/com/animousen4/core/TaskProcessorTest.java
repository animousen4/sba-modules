package com.animousen4.core;

import com.animousen4.core.entites.Group;
import com.animousen4.core.entites.GroupCalcRes;
import com.animousen4.core.entites.Match;
import com.animousen4.core.file.read.GroupFileReader;
import com.animousen4.core.file.read.MatchFileReader;
import com.animousen4.core.file.write.CommandResultOutputWriter;
import com.animousen4.core.file.write.GroupOutputWriter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TaskProcessorTest {

    @Mock
    GroupFileReader groupFileReader;

    @Mock
    MatchFileReader matchFileReader;

    @Mock
    CommandAnalyzer commandAnalyzer;

    @Mock
    GroupOutputWriter groupOutputWriter;

    @Mock
    CommandResultOutputWriter commandResultOutputWriter;

    @InjectMocks
    TaskProcessor taskProcessor;

    @Test
    void completeWriterTest() throws IOException {

        List<Match> matches = List.of(
                new Match("C1", 1, "C2", 1)
        );

        Map<String, GroupCalcRes> res = new LinkedHashMap<>(Map.of(
                "C1", new GroupCalcRes(2, 0, 1, 0, 1, 1),
                "C2", new GroupCalcRes(2, 0, 1, 0, 1, 1)
        ));
        List<Group> groups = List.of(
                new Group("A", List.of("C1", "C2"))
        );

        when(groupFileReader.read()).thenReturn(groups);

        when(matchFileReader.read()).thenReturn(matches);

        when(commandAnalyzer.getCalculatedMaps(matches)).thenReturn(res);

        AtomicReference<Boolean> groupWritten = new AtomicReference<>(false);
        AtomicReference<Boolean> commandResultWritten = new AtomicReference<>(false);
        doAnswer(
                x -> {
                    groupWritten.set(true);
                    return null;
                }
        ).when(commandResultOutputWriter).save(any());

        doAnswer(
                x -> {
                    commandResultWritten.set(true);
                    return null;
                }
        ).when(groupOutputWriter).save(any());

        taskProcessor.processTask();
        assertTrue(groupWritten.get());
        assertTrue(commandResultWritten.get());
    }
}
