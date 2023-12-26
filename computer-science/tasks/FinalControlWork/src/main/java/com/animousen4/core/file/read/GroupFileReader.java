package com.animousen4.core.file.read;

import com.animousen4.core.entites.Group;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class GroupFileReader extends InputReaderFile<List<Group>>{
    public GroupFileReader(String fileName) {
        super(fileName);
    }

    @Override
    public List<Group> read() throws FileNotFoundException {
        List<Group> groups = new ArrayList<>();
        Scanner s = new Scanner(new File(fileName));
        String curLine;
        List<String> parts;
        List<String> partsCommands;
        while (s.hasNextLine()) {
            curLine = s.nextLine();
            parts = Arrays.stream(curLine.split(" ")).toList();
            partsCommands = parts.subList(1, parts.size());
            String groupName = parts.get(0);
            groups.add(
                    Group.builder()
                            .groupName(groupName)
                            .commands(partsCommands)
                            .build()
            );
        }
        return groups;
    }
}
