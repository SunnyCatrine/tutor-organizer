package main.java.edu.catherine.tutorg.controller;

import main.java.edu.catherine.tutorg.model.client.StudentStatus;
import main.java.edu.catherine.tutorg.model.client.ext.Student;
import main.java.edu.catherine.tutorg.service.StudentService;

import java.sql.SQLException;
import java.util.List;

public final class StudentController {
    private final StudentService studentService = StudentService.getInstance();
    private static final StudentController INSTANCE = new StudentController();

    private StudentController() {
    }

    public static StudentController getINSTANCE() {
        return INSTANCE;
    }

//
    public Student create(Student studentRequest) throws SQLException {
        return studentService.create(studentRequest);
    }

    public List<Student> findAll() throws SQLException {
        return studentService.findAll();
    }

    public Student findBy(Integer studentId) throws SQLException {
        return studentService.findBy(studentId);
    }

    public Student update(Integer id, Student studentRequest) throws SQLException {
        return studentService.update(id, studentRequest);
    }

    public Student deleteBy(Integer studentId) throws SQLException {
        return studentService.deleteBy(studentId);
    }
}
