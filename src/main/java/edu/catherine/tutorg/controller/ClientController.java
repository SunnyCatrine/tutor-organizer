package main.java.edu.catherine.tutorg.controller;

import main.java.edu.catherine.tutorg.model.client.dto.CreateStudentRequestDto;
import main.java.edu.catherine.tutorg.model.client.dto.CreateStudentResponseDto;
import main.java.edu.catherine.tutorg.model.client.dto.FindStudentResponseDto;
import main.java.edu.catherine.tutorg.service.ClientService;

import java.util.List;

public final class ClientController {
    private final ClientService clientService = ClientService.getInstance();
    private static final ClientController INSTANCE = new ClientController();

    private ClientController() {
    }

    public static ClientController getINSTANCE() {
        return INSTANCE;
    }

    public CreateStudentResponseDto createStudent(CreateStudentRequestDto studentDto) {
        return clientService.createStudent(studentDto);
    }

    public List<FindStudentResponseDto> findAllStudents() {
        return clientService.findAllStudents();
    }
}
