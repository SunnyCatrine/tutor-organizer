package main.java.edu.catherine.tutorg;

import main.java.edu.catherine.tutorg.controller.ClientController;
import main.java.edu.catherine.tutorg.model.dto.CreateStudentRequestDto;
import main.java.edu.catherine.tutorg.model.dto.CreateStudentResponseDto;
import main.java.edu.catherine.tutorg.model.dto.FindStudentResponseDto;

import java.sql.SQLException;
import java.util.List;

public class TutorgLauncher {

    public static void main(String[] args) throws SQLException {
        ClientController clientController = ClientController.getINSTANCE();

        CreateStudentRequestDto studentDto = new CreateStudentRequestDto(
                "Vasiliy",
                "Terkin",
                "+79091234567",
                "VasyaTerkin",
                "Russia",
                "Moscow",
                "GMT +3",
                "MATH5",
                null,
                null,
                "1000",
                "60",
                "MONDAY",
                null,
                null,
                null,
                "12:00",
                null,
                null,
                null,
                "2022-09-23",
                "2023-05-31");


        CreateStudentResponseDto createStudentResponseDto = clientController.createStudent(studentDto);
        System.out.println(createStudentResponseDto);

        List<FindStudentResponseDto> findStudents = clientController.findAllStudents();
        for (FindStudentResponseDto findStudent: findStudents) {
            System.out.println(findStudent);
        }
    }
}