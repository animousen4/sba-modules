package com.animousen4.core.file.read;

import com.animousen4.core.entites.Match;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MatchFileReader extends InputReaderFile<List<Match>>{

    public MatchFileReader(String fileName) {
        super(fileName);
    }

    @Override
    public List<Match> read() throws FileNotFoundException {
        ArrayList<Match> lines = new ArrayList<Match>();
        Scanner s = new Scanner(new File(fileName));
        String curLine;
        List<String> parts;
        List<String> cm1;
        List<String> cm2;
        while (s.hasNextLine()) {
            curLine = s.nextLine();
            parts = Arrays.stream(curLine.split(":")).toList();

            int lastSpaceIndex = parts.get(0).lastIndexOf(" ");
            String[] result = {parts.get(0).substring(0, lastSpaceIndex), parts.get(0).substring(lastSpaceIndex + 1)};
            cm1 = Arrays.asList(result);

            int firstSpaceIndex = parts.get(1).indexOf(" ");
            String[] result2 = {parts.get(1).substring(0, firstSpaceIndex), parts.get(1).substring(firstSpaceIndex + 1)};
            cm2 = Arrays.asList(result2);


            lines.add(
                    Match.builder()
                            .commandOne(cm1.get(0))
                            .commandTwo(cm2.get(1))
                            .goalOne(Integer.parseInt(cm1.get(1)))
                            .goalTwo(Integer.parseInt(cm2.get(0)))
                            .build()
            );
        }
        s.close();

        return lines;
    }
}
