package kuttubek.dao.impl;


import kuttubek.dao.StudentDao;
import kuttubek.model.Student;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Repository
@Transactional
public class StudentDaoImpl implements StudentDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Student saveStudent(Student student) {
        entityManager.persist(student);
        return student;
    }

    @Override
    public void removeStudentById(Long id) {
        entityManager.remove(getById(id));
    }

    @Override
    public Student getById(Long id) {
        return entityManager.find(Student.class,id);
    }

    @Override
    public List<Student> getAllStudent() {
        return entityManager.createQuery("SELECT s FROM Student s", Student.class).getResultList();

    }

    @Override
    public void updateStudent(Long id, Student student) {
        Student student1 = getById(id);
        student1.setFirstName(student.getFirstName());
        student1.setLastName(student.getLastName());
        student1.setEmail(student.getEmail());
        student1.setStudyFormat(student.getStudyFormat());
        entityManager.merge(student);
    }
}
