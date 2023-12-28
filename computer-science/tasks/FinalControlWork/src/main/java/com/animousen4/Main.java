package com.animousen4;

import com.animousen4.core.CommandAnalyzer;
import com.animousen4.core.TaskProcessor;
import com.animousen4.core.file.read.GroupFileReader;
import com.animousen4.core.file.read.MatchFileReader;
import com.animousen4.core.file.write.CommandResultOutputWriter;
import com.animousen4.core.file.write.GroupOutputWriter;

import java.io.*;


public class Main {
    public static String workPath = "computer-science/tasks/FinalControlWork/";
    public static void main(String[] args) throws IOException {
        System.out.println("Program started");

        TaskProcessor taskProcessor = new TaskProcessor(
                new GroupFileReader(new FileReader(workPath.concat("groups.txt"))),
                new MatchFileReader(new FileReader(workPath.concat("game.txt"))),
                new GroupOutputWriter(new FileWriter(workPath.concat("GroupsOut.txt"))),
                new CommandResultOutputWriter(new FileWriter(workPath.concat("Results.txt"))),
                new CommandAnalyzer()
        );

        try {
            taskProcessor.processTask();
        } catch (IOException e) {
            System.err.println("An error occurred during working with file");
            e.printStackTrace();
        }

        System.out.println("Program successful finished");
    }
}