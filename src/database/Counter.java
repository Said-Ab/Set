package database;

public class Counter {
    public static Long groupId=0L;
    public static Long lessonId=0L;
    public static Long studentId=0L;
    public static Long counterGroupId(){
        return ++groupId;
    }
    public static Long counterLessonId(){
        return ++lessonId;
    }public static Long counterStudentId(){
        return ++studentId;
    }
}
