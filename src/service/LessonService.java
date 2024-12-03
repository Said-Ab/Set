package service;

import models.Lesson;

public interface LessonService {
    Lesson addNewLessonToGroup(String groupName,Lesson lesson);
    Lesson getLessonByName(String name);
    void getAllLessonByGroupName(String groupName);
    void deleteLesson(String name);
}
