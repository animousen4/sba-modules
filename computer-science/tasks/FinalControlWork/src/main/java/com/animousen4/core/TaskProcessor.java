package com.animousen4.core;

import com.animousen4.core.entites.Group;
import com.animousen4.core.entites.MappedGroup;
import com.animousen4.core.entites.Match;
import com.animousen4.core.file.read.GroupFileReader;
import com.animousen4.core.file.read.MatchFileReader;
import com.animousen4.core.file.write.CommandResultOutputWriter;
import com.animousen4.core.file.write.GroupOutputWriter;
import lombok.AllArgsConstructor;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@AllArgsConstructor
public class TaskProcessor {
    GroupFileReader groupFileReader;

    MatchFileReader matchFileReader;

    GroupOutputWriter groupOutputWriter;

    CommandResultOutputWriter commandResultOutputWriter;

    CommandAnalyzer commandAnalyzer;

    public void processTask() throws IOException {
        List<Group> groups = groupFileReader.read();
        List<Match> matches = matchFileReader.read();

        var maps = commandAnalyzer.getCalculatedMaps(matches);
        var mappedGroup = new MappedGroup(groups, maps);

        groupOutputWriter.save(mappedGroup);
        commandResultOutputWriter.save(mappedGroup);

    }

}
