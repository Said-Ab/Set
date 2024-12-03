package service.serviceIMPL;

import database.Database;
import models.Group;
import models.Lesson;
import service.LessonService;

public class LessonIMPL implements LessonService {
    private GroupIMPL groupIMPL = new GroupIMPL();

    @Override
    public Lesson addNewLessonToGroup(String groupName, Lesson lesson) {
        try {
            Group group = groupIMPL.getGroupByName(groupName);
            if (group == null) {
                throw new IllegalArgumentException("Группа с именем " + groupName + " не найдена.");
            } else {
                group.getLessons().add(lesson);
                return lesson;
            }
        } catch (Exception e) {
            System.out.println("Ошибка при добавлении Урока");
            throw new RuntimeException(e);
        }
    }

    @Override
    public Lesson getLessonByName(String name) {
        try {
            for (Group group : Database.groups) {
                for (Lesson lesson : group.getLessons()) {
                    if (lesson.getLessonName().equalsIgnoreCase(name)) {
                        return lesson;
                    }
                }
            }
            return null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void getAllLessonByGroupName(String groupName) {
        try {
            Group group = groupIMPL.getGroupByName(groupName);
            if (group == null) {
                throw new IllegalArgumentException("Группа с именем " + groupName + " не найдена.");
            }
            for (Lesson lesson : group.getLessons()) {
                System.out.println(lesson);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void deleteLesson(String name) {
        try {
            for (Group group : Database.groups) {
                for (Lesson lesson : group.getLessons()) {
                    if (lesson.getLessonName().equalsIgnoreCase(name)) {
                        group.getLessons().remove(lesson);
                        break;
                    }
                }
            }
            System.out.println("Урок не найден");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
