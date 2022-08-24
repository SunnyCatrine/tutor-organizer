package main.java.edu.catherine.tutorg.mapper;

import main.java.edu.catherine.tutorg.model.client.StudentStatus;
import main.java.edu.catherine.tutorg.model.client.dto.FindStudentResponseDto;
import main.java.edu.catherine.tutorg.model.client.ext.Student;
import main.java.edu.catherine.tutorg.model.lesson.SubjectBlock;

import java.util.stream.Collectors;

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
                responseStudent.getSubjects().stream()
                .map(SubjectBlock::getSubjectName).collect(Collectors.toList()),
                responseStudent.getDefaultLessonParam().getPrice().toString(),
                responseStudent.getDefaultLessonParam().getDuration().toString(),
                responseStudent.getSchedule().entrySet().stream()
                .map(dayOfWeekLocalDateTimeEntry -> dayOfWeekLocalDateTimeEntry.getKey().toString() + dayOfWeekLocalDateTimeEntry.getValue().toString())
                .collect(Collectors.toList()),
                responseStudent.getLessonsPeriod().getFirstLessonDate().toString(),
                responseStudent.getLessonsPeriod().getLastLessonDate().toString(),
                responseStudent.getStudentStatus().toString(),
                responseStudent.getAgent().getFirstName(),
                responseStudent.getAgent().getLastName(),
                responseStudent.getAgent().getContact().getPhoneNo(),
                responseStudent.getAgent().getLocation().getCountry(),
                responseStudent.getAgent().getLocation().getCity(),
                responseStudent.getAgent().getLocation().getTimezone()
                );
    }
}
