package main.java.edu.catherine.tutorg.mapper;

import main.java.edu.catherine.tutorg.model.client.StudentStatus;
import main.java.edu.catherine.tutorg.model.client.dto.FindStudentResponseDto;
import main.java.edu.catherine.tutorg.model.client.ext.Student;

public class FindStudentMapper {

    public static FindStudentResponseDto toDto(Student responseStudent) {
        return new FindStudentResponseDto(
                responseStudent.getFirstName(),
                responseStudent.getLastName(),
                responseStudent.getContact().getPhoneNo(),
                responseStudent.getContact().getSkype(),
                responseStudent.getLocation().getCountry(),
                responseStudent.getLocation().getCity(),
                responseStudent.getLocation().getTimezone(),
                responseStudent.getSubjects(),
                responseStudent.getDefaultLessonParam().getPrice(),
                responseStudent.getDefaultLessonParam().getDuration(),
                responseStudent.getSchedule().getSchedule(),
                responseStudent.getLessonsPeriod().getFirstLessonDate(),
                responseStudent.getLessonsPeriod().getLastLessonDate(),
                responseStudent.getStudentStatus(),
                responseStudent.getAgent().getFirstName(),
                responseStudent.getAgent().getLastName(),
                responseStudent.getAgent().getContact().getPhoneNo(),
                responseStudent.getAgent().getLocation().getCountry(),
                responseStudent.getAgent().getLocation().getCity(),
                responseStudent.getAgent().getLocation().getTimezone()
                );
    }
}
