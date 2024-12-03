package service.serviceIMPL;

import database.Database;
import models.Group;
import models.Lesson;
import models.Student;
import service.StudentService;

import java.util.List;

public class StudentIMPL implements StudentService {
    private GroupIMPL groupIMPL = new GroupIMPL();

    @Override
    public void addNewStudentToGroup(String groupName, Student student) {
        try {
            Group group = groupIMPL.getGroupByName(groupName);
            if (group == null) {
                throw new IllegalArgumentException("Группа с именем " + groupName + " не найдена.");
            } else {
                group.getStudents().add(student);
                student.setLessons(group.getLessons());
            }
        } catch (Exception e) {
            System.out.println("Ошибка при добавлении Урока");
            throw new RuntimeException(e);
        }
    }

    @Override
    public Student updateStudent(Student student, String email) {
        try {
            for (Group group : Database.groups) {
                for (Student student1 : group.getStudents()) {
                    if (student1.getEmail().equals(email)) {
                        student1.setName(student.getName());
                        student1.setLastName(student.getLastName());
                        student1.setEmail(student.getEmail());
                        student1.setGender(student.getGender());
                        student1.setPassword(student.getPassword());
                        return student1;
                    }
                }
            }
            return null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void findStudentByFirstName(String name) {
        try {
            boolean check = false;
            for (Group group : Database.groups) {
                for (Student student : group.getStudents()) {
                    if (student.getName().equalsIgnoreCase(name)) {
                        System.out.print(group.getGroupName() + ":");
                        System.out.println(student);
                        check = true;
                    }
                }
            }
            if (!check) {
                System.out.println("Нет студента с подобным именем");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Student> getAllStudentByGroupName(String groupName) {
        try {
            Group group = groupIMPL.getGroupByName(groupName);
            return group.getStudents();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteStudent(String email) {
        try {


            for (Group group : Database.groups) {
                for (Student student : group.getStudents()) {
                    if (student.getEmail().equals(email)) {
                        group.getStudents().remove(student);
                        System.out.println(student + "\nЭтот студент удален");
                        break;
                    }
                }
            }
            System.out.println("Студент не найден");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Lesson> getAllStudentLesson(String email) {
        try {
            for (Group group : Database.groups) {
                for (Student student : group.getStudents()) {
                    if (student.getEmail().equals(email)) {
                        return student.getLessons();
                    }
                }
            }
            return null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
