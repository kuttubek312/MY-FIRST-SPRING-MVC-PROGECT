package kuttubek.dao.impl;

import kuttubek.dao.CourseDao;
import kuttubek.model.Course;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class CourseDaoImpl implements CourseDao {


    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Course saveCourse(Course course) {
        entityManager.merge(course);
        return course;
    }

    @Override
    public void removeCourseById(Long id) {
        entityManager.remove(getById(id));
    }

    @Override
    public Course getById(Long id) {
        return entityManager.find(Course.class, id);
    }

    @Override
    public List<Course> getAllCourse() {
        return entityManager.createQuery("select c from Course c", Course.class).getResultList();
    }

    @Override
    public void updateCourse(Course course) {
        entityManager.merge(course);
    }
}