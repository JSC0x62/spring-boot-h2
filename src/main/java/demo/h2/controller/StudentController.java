package demo.h2.controller;

import demo.h2.domain.Student;
import demo.h2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/{username}")
    public Student getStudent(@PathVariable String username) {
        return studentService.getStudent(username);
    }

    @PostMapping
    public void registerStudent(@RequestBody Student student) {
        studentService.registerStudent(student);
    }

    @PutMapping(path = "/{username}")
    public void updateStudent(@RequestBody Student student, @PathVariable String username) {
        student.setUsername(username);
        studentService.updateStudent(student);
    }

    @DeleteMapping(path = "/{username}")
    public void deleteStudent(@PathVariable String username) {
        studentService.deleteStudent(username);
    }
}
