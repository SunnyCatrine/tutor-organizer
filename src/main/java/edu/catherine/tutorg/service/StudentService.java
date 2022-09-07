package main.java.edu.catherine.tutorg.service;

import main.java.edu.catherine.tutorg.dao.StudentDao;
import main.java.edu.catherine.tutorg.mapper.CreateStudentMapper;
import main.java.edu.catherine.tutorg.mapper.FindStudentMapper;
import main.java.edu.catherine.tutorg.model.client.impl.Student;
import main.java.edu.catherine.tutorg.model.dto.CreateStudentRequest;
import main.java.edu.catherine.tutorg.model.dto.CreateStudentResponse;
import main.java.edu.catherine.tutorg.model.dto.FindStudentResponse;
import main.java.edu.catherine.tutorg.util.ConnectionManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

public class StudentService {
    private final static StudentService INSTANCE = new StudentService();

    private final StudentDao studentDao = StudentDao.getInstance();

    public CreateStudentResponse create(CreateStudentRequest studentRequest) throws SQLException {
        Student student = CreateStudentMapper.toEntity(studentRequest);
        try (Connection connection = ConnectionManager.get()) {
            return CreateStudentMapper.toDto(studentDao.create(connection, student));
        }
    }

    public List<FindStudentResponse> findAll() throws SQLException {
        try (Connection connection = ConnectionManager.get()) {
            return studentDao.findAll(connection).stream()
                    .map(FindStudentMapper::toDto)
                    .collect(Collectors.toList());
        }
    }

    public FindStudentResponse findBy(Integer studentId) throws SQLException {
        try (Connection connection = ConnectionManager.get()) {
            return FindStudentMapper.toDto(studentDao.findBy(connection, studentId));
        }
    }

    public Student deleteBy(Integer studentId) throws SQLException {
        try (Connection connection = ConnectionManager.get()) {
            return studentDao.deleteBy(connection, studentId);
        }
    }

//    public Student update(Integer id, Student studentRequest) throws SQLException {
//        try (Connection connection = ConnectionManager.get()) {
//            return studentDao.update(connection, id, studentRequest);
//        }
//    }

    public static StudentService getInstance() {
        return INSTANCE;
    }

    private StudentService() {
    }

}
