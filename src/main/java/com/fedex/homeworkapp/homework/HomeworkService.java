package com.fedex.homeworkapp.homework;

import com.fedex.homeworkapp.post.Subject;

import java.util.List;

public interface HomeworkService {

    void saveHomework(Homework homework);

    void editHomework(Long id);

    void deleteHomework(Long id);

    Homework findById(Long id);

    List<Homework> getAllHomework();

    List<Homework> getHomeworksBySubject(Subject subject);

    Homework findByStudent(Long id);
}
