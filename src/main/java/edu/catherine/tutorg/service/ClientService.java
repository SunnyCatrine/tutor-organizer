package main.java.edu.catherine.tutorg.service;

import main.java.edu.catherine.tutorg.dao.ClientDao;
import main.java.edu.catherine.tutorg.mapper.CreateStudentMapper;
import main.java.edu.catherine.tutorg.mapper.FindStudentMapper;
import main.java.edu.catherine.tutorg.model.client.dto.CreateStudentRequestDto;
import main.java.edu.catherine.tutorg.model.client.dto.CreateStudentResponseDto;
import main.java.edu.catherine.tutorg.model.client.dto.FindStudentResponseDto;
import main.java.edu.catherine.tutorg.model.client.ext.Student;

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

    public CreateStudentResponseDto createStudent(CreateStudentRequestDto studentDto) {
        Student studentResponse = clientDao.createStudent(CreateStudentMapper.toEntity(studentDto));
        return CreateStudentMapper.toDto(studentResponse);
    }

    public List<FindStudentResponseDto> findAllStudents() {

        return clientDao.findAllStudents().stream()
                .map(FindStudentMapper::toDto)
                .collect(Collectors.toList());
    }
}
