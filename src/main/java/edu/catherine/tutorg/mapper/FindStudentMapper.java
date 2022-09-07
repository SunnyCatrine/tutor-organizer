package main.java.edu.catherine.tutorg.mapper;

import main.java.edu.catherine.tutorg.model.dto.FindStudentResponse;
import main.java.edu.catherine.tutorg.model.client.impl.Student;

public class FindStudentMapper {

    public static FindStudentResponse toDto(Student responseStudent) {
        return new FindStudentResponse(
                responseStudent.getClientId().toString(),
                responseStudent.getFirstName(),
                responseStudent.getLastName(),
                responseStudent.getStudentStatus().getStatusValue(),
                responseStudent.getContact().getPhoneNo(),
                responseStudent.getContact().getSkype(),
                responseStudent.getLocation().getCountry(),
                responseStudent.getLocation().getCity(),
                responseStudent.getLocation().getTimezone(),
                responseStudent.getDefaultLessonParam().getPrice().toString(),
                responseStudent.getDefaultLessonParam().getDuration().toString()
                );
    }
}
