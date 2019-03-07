package com.fedex.homeworkapp.homework;

import com.fedex.homeworkapp.post.Subject;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeworkServiceImp implements HomeworkService {
    @Override
    public void saveHomework(Homework homework) {

    }

    @Override
    public void editHomework(Long id) {

    }

    @Override
    public void deleteHomework(Long id) {

    }

    @Override
    public Homework findById(Long id) {
        return null;
    }

    @Override
    public List<Homework> getAllHomework() {
        return null;
    }

    @Override
    public List<Homework> getHomeworksBySubject(Subject subject) {
        return null;
    }
}
