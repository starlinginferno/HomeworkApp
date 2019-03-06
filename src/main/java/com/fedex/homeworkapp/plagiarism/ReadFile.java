package com.fedex.homeworkapp.plagiarism;

import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Getter
@Setter
public class ReadFile {

    private String filename1;
    private String filename2;
    private String filecontent1;
    private String filecontetnt2;

    public static String readFile(String filename) {

        Path filePath = Paths.get(filename);


        try {
            List<String> lines = Files.readAllLines(filePath);
            List<String[]> splitSentances = new ArrayList<>();
            for (String line : lines) {
                String[] tempSplitLines = line.split("[.!?:]");
                splitSentances.add(tempSplitLines);
            }

        } catch (IOException e) {
            e.getMessage();
            System.out.println("ERROR - Can't find the file");
        }
        String answer = "The rainiest city ";
        for (String years : rainiestCities) {
            answer = answer + years + " ";
        }
        return answer + " with " + maxCount + " times.";
    }

    public static void main(String[] args) {

        String filename = "cities.csv";
        System.out.println(mostRainyCity(filename));
        String filename2 = "cities2.csv";
        System.out.println(mostRainyCity(filename2));
    }
}
