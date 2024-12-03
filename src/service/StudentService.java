package service;

import models.Lesson;
import models.Student;

import java.util.List;

public interface StudentService {
    void addNewStudentToGroup(String groupName, Student student);
    Student updateStudent(Student student,String email);
    void findStudentByFirstName(String name);
    List<Student>getAllStudentByGroupName(String groupName);
    void deleteStudent(String email);
    List<Lesson>getAllStudentLesson(String email);

}