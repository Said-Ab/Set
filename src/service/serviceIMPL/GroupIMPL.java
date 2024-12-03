package service.serviceIMPL;

import database.Database;
import models.Group;
import service.GroupService;

public class GroupIMPL implements GroupService {
    @Override
    public Group addGroup(Group group) {
        Database.groups.add(group);
        return group;
    }

    @Override
    public Group getGroupByName(String name) {
        for (Group group : Database.groups) {
            if (group.getGroupName().equalsIgnoreCase(name)) {
                return group;
            }
        }
        return null;
    }

    @Override
    public void getAllGroups() {
        for (Group group:Database.groups){
            System.out.println(group);
        }
    }

    @Override
    public Group updateGroupName(String name, String newName) {
        for (Group group : Database.groups) {
            if (group.getGroupName().equalsIgnoreCase(name)) {
                group.setGroupName(newName);
                return group;
            }
        }
        return null;
    }

    @Override
    public void deleteGroup(String name) {
        Group group=getGroupByName(name);
        if (group == null) {
            throw new IllegalArgumentException("Группа с именем " + name + " не найдена.");
        }
        Database.groups.remove(group);

    }
}
