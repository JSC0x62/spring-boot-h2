package demo.h2.service;

import demo.h2.domain.Student;

public interface StudentService {

    Student getStudent(String username);

    void updateStudent(Student student);

    void registerStudent(Student student);

    void deleteStudent(String username);
}
