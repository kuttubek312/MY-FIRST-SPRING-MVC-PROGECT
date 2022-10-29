package kuttubek.service;

import kuttubek.model.Group;

import java.util.List;

public interface GroupService {

    Group saveGroup(Group group);

    void removeGroupById(Long id);

    Group getById(Long id);

    List<Group> getAllGroup();

    void updateGroup(Long id, Group group);
}
