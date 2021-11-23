package demo.h2.service.impl;

import demo.h2.dao.StudentRepository;
import demo.h2.domain.Student;
import demo.h2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.server.ResponseStatusException;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student getStudent(String username) {
        Student student = studentRepository.getStudent(username);
        if (ObjectUtils.isEmpty(student)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Student does not exist!");
        }
        return student;
    }

    @Override
    public void updateStudent(Student student) {
        Student studentDb = getStudent(student.getUsername());
        if (!studentDb.equals(student)) {
            studentRepository.updateStudent(student);
        }
    }

    @Override
    public void registerStudent(Student student) {
        if (!ObjectUtils.isEmpty(studentRepository.getStudent(student.getUsername()))) {
            throw new ResponseStatusException(
                    HttpStatus.FORBIDDEN, "Student already exists!");
        }
        studentRepository.registerStudent(student);
    }

    @Override
    public void deleteStudent(String username) {
        getStudent(username);
        studentRepository.deleteStudent(username);
    }
}
