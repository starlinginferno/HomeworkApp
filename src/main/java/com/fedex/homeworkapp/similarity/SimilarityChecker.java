package com.fedex.homeworkapp.plagiarism;

import com.fedex.homeworkapp.homework.Homework;
import com.fedex.homeworkapp.homework.HomeworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.fedex.homeworkapp.post.Subject.ENGLISH;

@Service
public class PlagiarismChecker {

    private HomeworkService homeworkService;

    @Autowired
    public PlagiarismChecker(HomeworkService homeworkService) {
        this.homeworkService = homeworkService;
    }

    public List<Homework> getEnglishHomeworks() {
        return homeworkService.getHomeworksBySubject(ENGLISH);
    }

    public Homework homeworkToMatch(Long id) {
        return homeworkService.findById(id);
    }
    public List<String> getContentOfOtherEnglishHomeworks(Long id) {
        Homework homework = homeworkToMatch(id);
        List<String> contents = new ArrayList<>();
        for(Homework otherHomework : getEnglishHomeworks()) {
            if (!homework.equals(otherHomework)){
                contents.add(homework.getContent());
            }
        }
        return contents;
    }

    public boolean matchFullCopy(Long id) {
        for(String content : getContentOfOtherEnglishHomeworks(id)) {
            if (homeworkToMatch(id).getContent().equalsIgnoreCase(content)) {
               return true;
            }
        }
        return false;
    }

    public int countWordsUsingSplit(String content) {
        if (content == null || content.isEmpty()) {
            return 0;
        }
        String[] words = content.split("\\s+");
        return words.length;
    }

    public void matchSentanceWithOtherWorks(Long id) {
       
    }

}
