package models;

import java.util.ArrayList;
import java.util.List;

public class Group {
    private Long id;
    private String groupName;
    private String description;
    private List<Student> students=new ArrayList<>();
    private List<Lesson> lessons=new ArrayList<>();



    public Group(Long id, String groupName, String description) {
        this.id = id;
        this.groupName = groupName;
        this.description = description;
    }

    public Group() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", groupName='" + groupName + '\'' +
                ", description='" + description + '\'' +
                ", students=" + students +
                ", lessons=" + lessons +
                '}';
    }
}
