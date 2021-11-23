package demo.h2.service.impl;

import demo.h2.dao.StudentRepository;
import demo.h2.domain.Student;
import demo.h2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public Student getStudent(String username) {
        return null;
    }

    @Override
    public void updateStudent(Student student) {

    }

    @Override
    public void registerStudent(Student student) {

    }

    @Override
    public void deleteStudent(String username) {

    }
}
