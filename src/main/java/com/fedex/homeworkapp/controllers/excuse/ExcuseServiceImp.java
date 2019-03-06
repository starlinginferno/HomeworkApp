package com.fedex.homeworkapp.controllers.excuse;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExcuseServiceImp implements ExcuseService {

    @Override
    public String generateExcuse() throws IOException {
        int random = (int) (Math.random() * 7);
            return listExcuses().get(random);
    }

    @Override
    public List<String> listExcuses() throws IOException {
        Path path = Paths.get("src/main/resources/excuses.txt");
        try {
            return Files.readAllLines(path)
                        .stream().map(l -> l.split("\\.\\s"))
                        .collect(Collectors.toList())
                        .stream()
                        .map(a -> a[1])
                        .collect(Collectors.toList());
            } catch (IOException e) {
                throw new IOException("Could not read file");
            }
        }

    @Override
    public ExcuseDTO mapExcuseDTO(String excuse) {
        ExcuseDTO excuseDTO = new ExcuseDTO();
        excuseDTO.setExcuse(excuse);
        return excuseDTO;
    }
}
