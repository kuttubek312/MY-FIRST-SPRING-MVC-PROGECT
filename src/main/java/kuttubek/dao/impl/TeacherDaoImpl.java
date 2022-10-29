package kuttubek.dao.impl;


import kuttubek.dao.TeacherDao;
import kuttubek.model.Teacher;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class TeacherDaoImpl implements TeacherDao {


    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Teacher saveTeacher(Teacher teacher) {
        entityManager.persist(teacher);
        return teacher;
    }

    @Override
    public void removeTeacherById(Teacher teacher) {
        entityManager.remove(entityManager.contains(teacher) ? teacher : entityManager.merge(teacher));
    }

    @Override
    public Teacher getById(Long id) {
        return entityManager.find(Teacher.class,id);
    }

    @Override
    public List<Teacher> getAllTeacher() {
        return entityManager.createQuery("select t from Teacher t",Teacher.class).getResultList();
    }

    @Override
    public void updateTeacher(Long id ,Teacher teacher) {
        Teacher teacher1 = getById(id);
        teacher1.setFirstName(teacher.getFirstName());
        teacher1.setLastName(teacher.getLastName());
        teacher1.setEmail(teacher.getEmail());
        entityManager.merge(teacher);
    }
}