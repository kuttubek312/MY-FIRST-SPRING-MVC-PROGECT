package kuttubek.service.impl;

import kuttubek.dao.StudentDao;
import kuttubek.model.Student;
import kuttubek.service.StudentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    private final StudentDao studentDao;

    public StudentServiceImpl(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public Student saveStudent(Student student) {
        return studentDao.saveStudent(student);
    }

    @Override
    public void removeStudentById(Long id) {
        studentDao.removeStudentById(id);
    }

    @Override
    public Student getById(Long id) {
        return studentDao.getById(id);
    }

    @Override
    public List<Student> getAllStudent() {
        return studentDao.getAllStudent();
    }

    @Override
    public void updateStudent(Long id, Student student) {
        studentDao.updateStudent(id, student);
    }
}
