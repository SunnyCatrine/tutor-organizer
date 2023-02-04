package main.java.edu.catherine.tutorg.service;

import lombok.SneakyThrows;
import main.java.edu.catherine.tutorg.dao.StudentDao;
import main.java.edu.catherine.tutorg.mapper.StudentMapper;
import main.java.edu.catherine.tutorg.model.dto.StudentRequest;
import main.java.edu.catherine.tutorg.model.dto.StudentResponse;
import main.java.edu.catherine.tutorg.model.entity.client.impl.Student;
import main.java.edu.catherine.tutorg.util.ConnectionManager;

import java.sql.Connection;
import java.util.List;
import java.util.stream.Collectors;

public class StudentService {
    private final static StudentService INSTANCE = new StudentService();

    private final StudentDao studentDao = StudentDao.getInstance();

    private StudentService() {
    }

    @SneakyThrows
    public StudentResponse create(StudentRequest studentRequest) {
        Student student = StudentMapper.toCreateEntity(studentRequest);
        try (Connection connection = ConnectionManager.get()) {
            return StudentMapper.toResponse(studentDao.create(connection, student));
        }
    }

    @SneakyThrows
    public List<StudentResponse> findAll() {
        try (Connection connection = ConnectionManager.get()) {
            return studentDao.findAll(connection).stream()
                    .map(StudentMapper::toResponse)
                    .collect(Collectors.toList());
        }
    }

    @SneakyThrows
    public StudentResponse findBy(Integer studentId) {
        try (Connection connection = ConnectionManager.get()) {
            return StudentMapper.toResponse(studentDao.findBy(connection, studentId));
        }
    }

    @SneakyThrows
    public StudentResponse deleteBy(Integer studentId) {
        try (Connection connection = ConnectionManager.get()) {
            return StudentMapper.toResponse(studentDao.deleteBy(connection, studentId));
        }
    }

    @SneakyThrows
    public StudentResponse update(Integer id, StudentRequest studentRequest) {
        Student student = StudentMapper.toUpdateEntity(studentRequest);
        try (Connection connection = ConnectionManager.get()) {
            return StudentMapper.toResponse((studentDao.update(connection, id, student)));
        }
    }

    @SneakyThrows
    public Boolean assignAgent(String studentId, String agentId) {
        Integer intStudentId = Integer.parseInt(studentId);
        Integer intAgentId = Integer.parseInt(agentId);
        try (Connection connection = ConnectionManager.get()) {
            return studentDao.assignAgent(connection, intStudentId, intAgentId);
        }
    }

    public static StudentService getInstance() {
        return INSTANCE;
    }
}
