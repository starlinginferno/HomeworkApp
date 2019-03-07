package com.fedex.homeworkapp.similarity;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReadFile {

    public List<String> readFile(String filepath) {
        Path filePath1 = Paths.get(filepath);
        List<String> sentancesOfText = new ArrayList<>();
        try {
            String text = Files.readString(filePath1);
            sentancesOfText = Arrays.asList(text.split("[.,!?]"));
        } catch (IOException e) {
            e.getMessage();
            System.out.println("ERROR - Can't find the file");
        }
    return sentancesOfText;
    }

}
