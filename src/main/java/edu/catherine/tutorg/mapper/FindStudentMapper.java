package main.java.edu.catherine.tutorg.mapper;

import main.java.edu.catherine.tutorg.model.dto.FindStudentResponseDto;
import main.java.edu.catherine.tutorg.model.client.impl.Student;

public class FindStudentMapper {

    public static FindStudentResponseDto toDto(Student responseStudent) {
        return new FindStudentResponseDto(
                responseStudent.getClientId(),
                responseStudent.getFirstName(),
                responseStudent.getLastName(),
                responseStudent.getStudentStatus().getStatusValue()
                );
    }
}
