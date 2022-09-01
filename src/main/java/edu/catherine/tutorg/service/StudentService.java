package main.java.edu.catherine.tutorg.service;

import main.java.edu.catherine.tutorg.dao.StudentDao;
import main.java.edu.catherine.tutorg.model.client.impl.Student;
import main.java.edu.catherine.tutorg.util.ConnectionManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class StudentService {
    // TODO: 30.08.2022 make clean code in class (proper methods\fields order, indents, no comments etc.)
    private final static StudentService INSTANCE = new StudentService();

    private final StudentDao studentDao = StudentDao.getInstance();

    public Student create(Student studentRequest) throws SQLException {
        try (Connection connection = ConnectionManager.get()) {
            return studentDao.create(connection, studentRequest);
        }
    }

    public List<Student> findAll() throws SQLException {
        try (Connection connection = ConnectionManager.get()) {
            return studentDao.findAll(connection);
        }
    }

    public Student findBy(Integer studentId) throws SQLException {
        try (Connection connection = ConnectionManager.get()) {
            return studentDao.findBy(connection, studentId);
        }
    }

    public Student deleteBy(Integer studentId) throws SQLException {
        try (Connection connection = ConnectionManager.get()) {
            return studentDao.deleteBy(connection, studentId);
        }
    }

    public Student update(Integer id, Student studentRequest) throws SQLException {
        try (Connection connection = ConnectionManager.get()) {
            return studentDao.update(connection, id, studentRequest);
        }
    }

    public static StudentService getInstance() {
        return INSTANCE;
    }

    private StudentService() {
    }

}
