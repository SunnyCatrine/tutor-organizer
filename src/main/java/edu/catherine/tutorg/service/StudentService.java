package main.java.edu.catherine.tutorg.service;

import main.java.edu.catherine.tutorg.dao.StudentDao;
import main.java.edu.catherine.tutorg.mapper.StudentMapper;
import main.java.edu.catherine.tutorg.model.entity.client.impl.Student;
import main.java.edu.catherine.tutorg.model.dto.StudentRequest;
import main.java.edu.catherine.tutorg.model.dto.StudentResponse;
import main.java.edu.catherine.tutorg.util.ConnectionManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

public class StudentService {
    private final static StudentService INSTANCE = new StudentService();

    private final StudentDao studentDao = StudentDao.getInstance();

    public StudentResponse create(StudentRequest studentRequest) throws SQLException {
        Student student = StudentMapper.toEntity(studentRequest);
        try (Connection connection = ConnectionManager.get()) {
            return StudentMapper.toDto(studentDao.create(connection, student));
        }
    }

    public List<StudentResponse> findAll() throws SQLException {
        try (Connection connection = ConnectionManager.get()) {
            return studentDao.findAll(connection).stream()
                    .map(StudentMapper::toDto)
                    .collect(Collectors.toList());
        }
    }

    public StudentResponse findBy(Integer studentId) throws SQLException {
        try (Connection connection = ConnectionManager.get()) {
            return StudentMapper.toDto(studentDao.findBy(connection, studentId));
        }
    }

    public StudentResponse deleteBy(Integer studentId) throws SQLException {
        try (Connection connection = ConnectionManager.get()) {
            return StudentMapper.toDto(studentDao.deleteBy(connection, studentId));
        }
    }

    public StudentResponse update(Integer id, StudentRequest studentRequest) throws SQLException {
        Student student = StudentMapper.toEntity(studentRequest);
        try (Connection connection = ConnectionManager.get()) {
            return StudentMapper.toDto((studentDao.update(connection, id, student)));
        }
    }

    public static StudentService getInstance() {
        return INSTANCE;
    }

    private StudentService() {
    }

}
