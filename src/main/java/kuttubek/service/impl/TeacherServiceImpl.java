package kuttubek.service.impl;

import kuttubek.dao.TeacherDao;
import kuttubek.model.Teacher;
import kuttubek.service.TeacherService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TeacherServiceImpl implements TeacherService {

    private final TeacherDao teacherDao;

    public TeacherServiceImpl(TeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }

    @Override
    public Teacher saveTeacher(Teacher teacher) {
        return teacherDao.saveTeacher(teacher);
    }

    @Override
    public void removeTeacherById(Teacher teacher) {
        teacherDao.removeTeacherById(teacher);
    }

    @Override
    public Teacher getById(Long id) {
        return teacherDao.getById(id);
    }

    @Override
    public List<Teacher> getAllTeacher() {
        return teacherDao.getAllTeacher();
    }

    @Override
    public void updateTeacher(Long id, Teacher teacher) {
        teacherDao.updateTeacher(id, teacher);
    }
}
