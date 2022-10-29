package kuttubek.service.impl;

import kuttubek.dao.CourseDao;
import kuttubek.model.Course;
import kuttubek.service.CourseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class CourseServiceImpl implements CourseService {

    private final CourseDao courseDao;

    public CourseServiceImpl(CourseDao courseDao) {
        this.courseDao = courseDao;
    }

    @Override
    public Course saveCourse(Course course) {
        return courseDao.saveCourse(course);
    }

    @Override
    public void removeCourseById(Long id) {
        courseDao.removeCourseById(id);
    }

    @Override
    public Course getById(Long id) {
        return courseDao.getById(id);
    }

    @Override
    public List<Course> getAllCourse() {
        return courseDao.getAllCourse();
    }

    @Override
    public void updateCourse(Course course) {
        courseDao.updateCourse(course);
    }
}
