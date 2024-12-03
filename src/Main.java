import database.Counter;
import enums.Gender;
import models.Group;
import models.Lesson;
import models.Student;
import service.GroupService;
import service.LessonService;
import service.StudentService;
import service.serviceIMPL.GroupIMPL;
import service.serviceIMPL.LessonIMPL;
import service.serviceIMPL.StudentIMPL;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        GroupService groupService = new GroupIMPL();
        LessonService lessonService = new LessonIMPL();
        StudentService studentService = new StudentIMPL();


        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);

        while (true) {
            try {
                int hour = LocalDateTime.now().getHour();
                int minute = LocalDateTime.now().getMinute();
                System.out.printf("%02d:%02d  ", hour, minute);


                if (hour >= 6 && hour <= 12) {
                    System.out.println("Доброе утро");
                } else if (hour > 12 && hour <= 18) {
                    System.out.println("Добрый день");
                } else if (hour > 18 && hour < 22) {
                    System.out.println("Добрый вечер");
                } else {
                    System.out.println("Доброй ночи");
                }

                String email = "qwerty";
                String password = "qwerty";
                System.out.println("Введите пороль и почту от админа");
                System.out.println("Электронная почта:");
                String inputEmail = scanner1.nextLine();
                System.out.println("Пороль:");
                String inputPassword = scanner1.nextLine();


                if (email.equals(inputEmail) && password.equals(inputPassword)) {
                    System.out.println("Добро пожаловать");

                    while (true) {
                        try {
                            System.out.println("""
                                1  -> Add group
                                2  -> Get group by name
                                3  -> Update group name
                                4  -> Get all groups
                                5  -> Add new student to group
                                6  -> Update student
                                7  -> Find student by first name
                                8  -> Get all students by group name
                                9  -> Get all student's lessons
                                10 -> Delete student
                                11 -> Add new lesson to group
                                12 -> Get lesson by name
                                13 -> Get all lessons by group name
                                14 -> Delete lesson
                                15 -> Delete group
                                """);
                            System.out.println("Выберите действие:");
                            int choice = scanner.nextInt();
                            scanner.nextLine();
                            switch (choice) {
                                case 1 -> {
                                    System.out.println("Group name:");
                                    String name = scanner1.nextLine();
                                    System.out.println("Group description:");
                                    String description = scanner1.nextLine();
                                    System.out.println(groupService.addGroup(new Group(Counter.counterGroupId(), name, description)));
                                }
                                case 2 -> {
                                    System.out.println("Write group name:");
                                    System.out.println(groupService.getGroupByName(scanner1.nextLine()));
                                }
                                case 3 -> {
                                    System.out.println("Group name:");
                                    String name = scanner1.nextLine();
                                    System.out.println("New name:");
                                    System.out.println(groupService.updateGroupName(name, scanner1.nextLine()));
                                }
                                case 4 -> {
                                    groupService.getAllGroups();
                                }
                                case 5 -> {
                                    System.out.println("Write group name:");
                                    String groupName = scanner1.nextLine();
                                    Group group = groupService.getGroupByName(groupName);
                                    if (group == null) {
                                        System.out.println("Group not found.");
                                        break;
                                    }
                                    long id = Counter.counterStudentId();
                                    System.out.println("Write student's first name:");
                                    String firstName = scanner1.nextLine();
                                    System.out.println("Write last name:");
                                    String lastName = scanner1.nextLine();
                                    System.out.println("Write email:");
                                    String email1 = scanner1.nextLine();
                                    System.out.println("Write password:");
                                    String password1 = scanner1.nextLine();
                                    System.out.println("Write gender (MALE/FEMALE):");
                                    Gender gender = Gender.valueOf(scanner1.nextLine().toUpperCase());
                                    studentService.addNewStudentToGroup(groupName, new Student(id, firstName, lastName, email1, password1, gender));
                                }
                                case 6 -> {
                                    System.out.println("Write the email of the student to update:");
                                    String emailToUpdate = scanner1.nextLine();
                                    System.out.println("Write student's first name:");
                                    String firstName = scanner1.nextLine();
                                    System.out.println("Write last name:");
                                    String lastName = scanner1.nextLine();
                                    System.out.println("Write new email:");
                                    String newEmail = scanner1.nextLine();
                                    System.out.println("Write new password:");
                                    String newPassword = scanner1.nextLine();
                                    System.out.println("Write gender (MALE/FEMALE):");
                                    Gender gender = Gender.valueOf(scanner1.nextLine().toUpperCase());
                                    System.out.println(studentService.updateStudent(
                                            new Student(1L, firstName, lastName, newEmail, newPassword, gender), emailToUpdate
                                    ));
                                }
                                case 7 -> {
                                    System.out.println("Write student's first name:");
                                    studentService.findStudentByFirstName(scanner1.nextLine());
                                }
                                case 8 -> {
                                    System.out.println("Write group name:");
                                    System.out.println(studentService.getAllStudentByGroupName(scanner1.nextLine()));
                                }
                                case 9 -> {
                                    System.out.println("Write student's email:");
                                    System.out.println(studentService.getAllStudentLesson(scanner1.nextLine()));
                                }
                                case 10 -> {
                                    System.out.println("Write student's email:");
                                    studentService.deleteStudent(scanner1.nextLine());
                                }
                                case 11 -> {
                                    System.out.println("Write group name:");
                                    String groupName = scanner1.nextLine();
                                    System.out.println("Write lesson name:");
                                    String lessonName = scanner1.nextLine();
                                    System.out.println("Write description:");
                                    String lessonDescription = scanner1.nextLine();
                                    lessonService.addNewLessonToGroup(groupName, new Lesson(Counter.counterLessonId(), lessonName, lessonDescription));
                                }
                                case 12 -> {
                                    System.out.println("Write lesson name:");
                                    System.out.println(lessonService.getLessonByName(scanner1.nextLine()));
                                }
                                case 13 -> {
                                    System.out.println("Write group name:");
                                    lessonService.getAllLessonByGroupName(scanner1.nextLine());
                                }
                                case 14 -> {
                                    System.out.println("Write lesson name:");
                                    lessonService.deleteLesson(scanner1.nextLine());
                                }
                                case 15 -> {
                                    System.out.println("Write group name:");
                                    groupService.deleteGroup(scanner1.nextLine());
                                }
                                default -> System.out.println("Неверный выбор. Попробуйте снова.");
                            }
                        } catch (Exception e) {
                            System.out.println("Ошибка в меню: " + e.getMessage());
                            scanner.nextLine();
                        }
                    }
                } else {
                    System.out.println("Почта или пороль не верный!");
                }
            } catch (Exception e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        }
    }
}
