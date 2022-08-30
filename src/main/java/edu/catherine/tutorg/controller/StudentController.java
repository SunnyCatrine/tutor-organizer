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
//
//    public Student findBy(Integer studentId) {
//        return studentService.findBy(studentId);
//    }
//
//    public Student update(Student studentRequest) {
//        return studentService.update(studentRequest);
//    }
//
//    public Student deleteBy(Integer studentId) {
//        return studentService.deleteBy(studentId);
//    }
}
