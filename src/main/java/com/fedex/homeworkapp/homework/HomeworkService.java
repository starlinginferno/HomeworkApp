package com.fedex.homeworkapp.homework;

import java.util.List;

public interface HomeworkService {

    void saveHomework(Homework homework);

    void editHomework(Long id);

    void deleteHomework(Long id);

    List<Homework> getAllHomework();
}
