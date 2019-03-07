package com.fedex.homeworkapp.similarity;

import com.fedex.homeworkapp.homework.Homework;
import com.fedex.homeworkapp.homework.HomeworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static com.fedex.homeworkapp.post.Subject.ENGLISH;

@Service
public class SimilarityChecker {

    private HomeworkService homeworkService;

    @Autowired
    public SimilarityChecker(HomeworkService homeworkService) {
        this.homeworkService = homeworkService;
    }

    public List<Homework> getEnglishHomeworks() {
        return homeworkService.getHomeworksBySubject(ENGLISH);
    }

    public Homework homeworkToMatch(Long id) {
        return homeworkService.findById(id);
    }

    public List<Homework> otherEnglishHomeworksToMatch(Long id) {
        List<Homework> otherHomeworks = getEnglishHomeworks();
        otherHomeworks.remove(homeworkToMatch(id));
        return otherHomeworks;
    }

    public List<Homework> matchFullCopy(Long id) {
        List<Homework> matches = otherEnglishHomeworksToMatch(id);
        matches.stream()
                .filter(content -> content.getContent()
                        .equalsIgnoreCase(homeworkToMatch(id).getContent()));
        if (matches.size() == 0) {
            return null;
        }
        return matches;
    }

    public HashMap<Long, Double> matchSentences(Long id) {
        Homework homeworkToCheck = homeworkToMatch(id);
        List<Homework> otherHomeworks = otherEnglishHomeworksToMatch(id);
        HashMap<Long, Double> similarity = new HashMap<>();
        List<String> splitBySentence = Arrays.asList(homeworkToCheck.getContent().split("."));
        int counter = 0;

        for(Homework homework : otherHomeworks) {
            for(String sentence : splitBySentence) {
                if(homework.getContent().contains(sentence)) {
                    similarity.put(homework.getId(), similarity.getOrDefault(homework.getId(), 0.00) + 1);
                }
            }
        }
        return similarity;
    }

    public HashMap<Long, Double> similarityPercentage(Long id, HashMap<Long, Double> similarity) {
        int wordCount =
        HashMap<Long, Double> similarityPercentage = new HashMap<>();
        for(Long key : similarity.keySet()) {
            similarityPercentage.put(key, (similarity.get(key) / 5 * 100.00));
        }
    }
}
