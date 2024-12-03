package service;

import models.Group;

public interface GroupService {
    Group addGroup(Group group);
    Group getGroupByName(String name);
    void getAllGroups();
    Group updateGroupName(String name,String newName);
    void deleteGroup(String name);
}
