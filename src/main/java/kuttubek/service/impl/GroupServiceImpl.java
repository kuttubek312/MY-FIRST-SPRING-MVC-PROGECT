package kuttubek.service.impl;

import kuttubek.dao.GroupDao;
import kuttubek.model.Group;
import kuttubek.service.GroupService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class GroupServiceImpl implements GroupService {

    private final GroupDao groupDao;

    public GroupServiceImpl(GroupDao groupDao) {
        this.groupDao = groupDao;
    }

    @Override
    public Group saveGroup(Group group) {
        return groupDao.saveGroup(group);
    }

    @Override
    public void removeGroupById(Long id) {
        groupDao.removeGroupById(id);
    }

    @Override
    public Group getById(Long id) {
        return groupDao.getById(id);
    }

    @Override
    public List<Group> getAllGroup() {
        return groupDao.getAllGroup();
    }

    @Override
    public void updateGroup(Long id, Group group) {
        groupDao.updateGroup(id, group);
    }
}
