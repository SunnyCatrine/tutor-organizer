package main.java.edu.catherine.tutorg;

import main.java.edu.catherine.tutorg.controller.ClientController;
import main.java.edu.catherine.tutorg.model.client.dto.CreateStudentRequestDto;
import main.java.edu.catherine.tutorg.model.client.dto.CreateStudentResponseDto;
import main.java.edu.catherine.tutorg.model.client.ext.Student;
import main.java.edu.catherine.tutorg.model.lesson.SubjectBlock;

import java.sql.SQLException;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.*;

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
                "Math5",
                null,
                null,
                "1000",
                "60",
                "Monday",
                null,
                null,
                null,
                "12:00",
                null,
                null,
                null,
                "13.09.2022",
                "31.05.2023");

        CreateStudentResponseDto addedStudent = clientController.createStudent(studentDto);
        

    }
}
