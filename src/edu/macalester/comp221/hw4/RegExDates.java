package edu.macalester.comp221.hw4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class RegExDates {
    private String detectDates(List<String> input) {
        List<String> dateList = new ArrayList<>();

        for (String line : input) {
            // Day Month, Year
            if (line.matches("^([0-3]+[0-9]*) [A-Z]+[a-z]+(, [1-3]+[0-9]+[0-9]+[0-9]+)$")) {
                dateList.add(line);
            }

            // Month Day, Year
            if (line.matches("^([A-Z]+[a-z]+) [0-3]*[0-9]*(, [1-3]+[0-9]+[0-9]+[0-9]+)$")) {
                dateList.add(line);
            }

            // MM/DD/YY
            if (line.matches("^([0-9]+([1-2]+|[1-9]+))/[0-3]+[1-9]*(/[0-9]+[0-9]+)$")) {
                dateList.add(line);
            }

            // MM/DD/YYYY
            if (line.matches("^([0-9]+([1-2]+|[1-9]+))/[0-3]+[1-9]*(/[1-3]+[0-9]+[0-9]+[0-9]+)$")) {
                dateList.add(line);
            }

            // YYYY/MM/DD
            if (line.matches("^([1-3]+[0-9]+[0-9]+[0-9]+)/([0-9]+([1-2]+|[1-9]+))*(/[0-3]+[1-9]*)$")) {
                dateList.add(line);
            }

            // MM-DD-YYYY
            if (line.matches("^([0-9]+([1-2]+|[1-9]+))-[0-3]+[1-9]*(-[1-3]+[0-9]+[0-9]+[0-9]+)$")) {
                dateList.add(line);
            }
        }
        
        return dateList.toString();
    }
    
    public static void main(String[] args) throws Exception {
        RegExDates regex = new RegExDates();
        File input = new File("res/input.txt");
        BufferedReader readIn = new BufferedReader(new FileReader(input));
        List<String> contents = new ArrayList<>();
        String line;

        while((line = readIn.readLine()) != null) {
            if (!line.isEmpty()) {
                if (!line.substring(0, 1).equals("#")) {
                    contents.add(line);
                }
            }
        }

        readIn.close();

        System.out.println(regex.detectDates(contents));
    }
}
