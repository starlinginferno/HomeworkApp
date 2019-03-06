package com.fedex.homeworkapp.homework;

public interface HomeworkService {

    void saveHomework(Homework homework);

    void editHomework(Long id);

    void deleteHomework(Long id);
}
