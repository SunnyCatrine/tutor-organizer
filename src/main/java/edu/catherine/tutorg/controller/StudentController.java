package main.java.edu.catherine.tutorg.controller;

import main.java.edu.catherine.tutorg.model.client.impl.Student;
import main.java.edu.catherine.tutorg.model.dto.CreateStudentRequest;
import main.java.edu.catherine.tutorg.model.dto.CreateStudentResponse;
import main.java.edu.catherine.tutorg.model.dto.FindStudentResponse;
import main.java.edu.catherine.tutorg.service.StudentService;

import java.sql.SQLException;
import java.util.List;

public final class StudentController {
    private static final StudentController INSTANCE = new StudentController();

    private final StudentService studentService = StudentService.getInstance();

    public CreateStudentResponse create(CreateStudentRequest studentRequest) throws SQLException {
        return studentService.create(studentRequest);
    }

    public List<FindStudentResponse> findAll() throws SQLException {
        return studentService.findAll();
    }

    public FindStudentResponse findBy(Integer studentId) throws SQLException {
        return studentService.findBy(studentId);
    }

//    public Student update(Integer id, Student studentRequest) throws SQLException {
//        return studentService.update(id, studentRequest);
//    }

    public Student deleteBy(Integer studentId) throws SQLException {
        return studentService.deleteBy(studentId);
    }

    public static StudentController getINSTANCE() {
        return INSTANCE;
    }

    private StudentController() {
    }
}
