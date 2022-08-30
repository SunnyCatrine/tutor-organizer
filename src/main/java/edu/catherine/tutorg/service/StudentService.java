package main.java.edu.catherine.tutorg.service;

import main.java.edu.catherine.tutorg.dao.StudentDao;
import main.java.edu.catherine.tutorg.model.client.ext.Student;
import main.java.edu.catherine.tutorg.util.ConnectionManager;

import java.sql.Connection;
import java.sql.SQLException;

public class StudentService {
    private final StudentDao studentDao = StudentDao.getInstance();
    private final static StudentService INSTANCE = new StudentService();

    private StudentService() {
    }

    public static StudentService getInstance() {
        return INSTANCE;
    }

    public Student create(Student studentRequest) throws SQLException {
        try (Connection connection = ConnectionManager.get()) {
            return studentDao.create(connection, studentRequest);
        }
    }

//    public CreateStudentResponseDto createStudent(CreateStudentRequestDto studentDto) throws SQLException {
//        try (Connection connection = ConnectionManager.get()) {
//
//            Student studentResponse = clientDao.createStudent(CreateStudentMapper.toEntity(studentDto), connection);
//            return CreateStudentMapper.toDto(studentResponse);
//        } catch (Exception e) {
//            throw e;
//        }
//    }
//
//    public List<FindStudentResponseDto> findAllStudents() throws SQLException {
//        try (Connection connection = ConnectionManager.get()) {
//
//            return clientDao.findAllStudents(connection).stream()
//                    .map(FindStudentMapper::toDto)
//                    .collect(Collectors.toList());
//        } catch (Exception e) {
//            throw e;
//        }
//    }
    
    
}
