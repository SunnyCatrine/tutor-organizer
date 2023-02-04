package main.java.edu.catherine.tutorg.controller;

import lombok.SneakyThrows;
import main.java.edu.catherine.tutorg.model.dto.StudentRequest;
import main.java.edu.catherine.tutorg.model.dto.StudentResponse;
import main.java.edu.catherine.tutorg.service.StudentService;

import java.util.List;

public final class StudentController {
    private static final StudentController INSTANCE = new StudentController();

    private final StudentService studentService = StudentService.getInstance();

    @SneakyThrows
    public StudentResponse create(StudentRequest studentRequest) {
        return studentService.create(studentRequest);
    }

    @SneakyThrows
    public List<StudentResponse> findAll() {
        return studentService.findAll();
    }

    @SneakyThrows
    public StudentResponse findBy(Integer studentId) {
        return studentService.findBy(studentId);
    }

    @SneakyThrows
    public StudentResponse update(Integer id, StudentRequest studentRequest) {
        return studentService.update(id, studentRequest);
    }

    @SneakyThrows
    public StudentResponse deleteBy(Integer studentId) {
        return studentService.deleteBy(studentId);
    }

    @SneakyThrows
    public Boolean assignAgent(String studentId, String agentId) {
        return studentService.assignAgent(studentId, agentId);
    }

    public static StudentController getINSTANCE() {
        return INSTANCE;
    }

    private StudentController() {
    }
}
