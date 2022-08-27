package main.java.edu.catherine.tutorg.service;

import main.java.edu.catherine.tutorg.dao.ClientDao;
import main.java.edu.catherine.tutorg.mapper.CreateStudentMapper;
import main.java.edu.catherine.tutorg.mapper.FindStudentMapper;
import main.java.edu.catherine.tutorg.model.client.ext.Student;
import main.java.edu.catherine.tutorg.model.dto.CreateStudentRequestDto;
import main.java.edu.catherine.tutorg.model.dto.CreateStudentResponseDto;
import main.java.edu.catherine.tutorg.model.dto.FindStudentResponseDto;
import main.java.edu.catherine.tutorg.util.ConnectionManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

public class ClientService {
    private final ClientDao clientDao = ClientDao.getInstance();
    private final static ClientService INSTANCE = new ClientService();

    private ClientService() {
    }

    public static ClientService getInstance() {
        return INSTANCE;
    }

    public CreateStudentResponseDto createStudent(CreateStudentRequestDto studentDto) throws SQLException {
        try (Connection connection = ConnectionManager.get()) {

            Student studentResponse = clientDao.createStudent(CreateStudentMapper.toEntity(studentDto), connection);
            return CreateStudentMapper.toDto(studentResponse);
        } catch (Exception e) {
            throw e;
        }
    }

    public List<FindStudentResponseDto> findAllStudents() throws SQLException {
        try (Connection connection = ConnectionManager.get()) {

            return clientDao.findAllStudents(connection).stream()
                    .map(FindStudentMapper::toDto)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw e;
        }
    }
}
