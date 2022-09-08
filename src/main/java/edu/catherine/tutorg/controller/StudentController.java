package main.java.edu.catherine.tutorg.controller;

import main.java.edu.catherine.tutorg.model.dto.StudentRequest;
import main.java.edu.catherine.tutorg.model.dto.StudentResponse;
import main.java.edu.catherine.tutorg.service.StudentService;

import java.sql.SQLException;
import java.util.List;

public final class StudentController {
    private static final StudentController INSTANCE = new StudentController();

    private final StudentService studentService = StudentService.getInstance();

    public StudentResponse create(StudentRequest studentRequest) throws SQLException {
        return studentService.create(studentRequest);
    }

    public List<StudentResponse> findAll() throws SQLException {
        return studentService.findAll();
    }

    public StudentResponse findBy(Integer studentId) throws SQLException {
        return studentService.findBy(studentId);
    }

    public StudentResponse update(Integer id, StudentRequest studentRequest) throws SQLException {
        return studentService.update(id, studentRequest);
    }

    public StudentResponse deleteBy(Integer studentId) throws SQLException {
        return studentService.deleteBy(studentId);
    }

    public static StudentController getINSTANCE() {
        return INSTANCE;
    }

    private StudentController() {
    }
}
