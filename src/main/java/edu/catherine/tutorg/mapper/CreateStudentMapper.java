package main.java.edu.catherine.tutorg.mapper;

import main.java.edu.catherine.tutorg.model.client.Contact;
import main.java.edu.catherine.tutorg.model.client.Location;
import main.java.edu.catherine.tutorg.model.client.StudentStatus;
import main.java.edu.catherine.tutorg.model.dto.CreateStudentRequest;
import main.java.edu.catherine.tutorg.model.dto.CreateStudentResponse;
import main.java.edu.catherine.tutorg.model.client.impl.Student;
import main.java.edu.catherine.tutorg.model.lesson.LessonParam;

public class CreateStudentMapper {

    public static Student toEntity(CreateStudentRequest studentRequest) {
        Contact contact = new Contact(
                studentRequest.getPhoneNo(),
                studentRequest.getSkype()
        );

        Location location = new Location(
                studentRequest.getCountry(),
                studentRequest.getCity(),
                studentRequest.getTimezone()
        );

        LessonParam defaultLessonParam = new LessonParam(
                Integer.parseInt(studentRequest.getDefaultPrice()),
                Integer.parseInt(studentRequest.getDefaultDurationInMinutes())
        );

        String studentStatusValue = studentRequest.getStudentStatus();
        StudentStatus studentStatus = studentStatusValue == null
                ? null
                : StudentStatus.valueOf(studentStatusValue);


        return new Student(
                studentRequest.getFirstName(),
                studentRequest.getLastName(),
                contact,
                location,
                defaultLessonParam,
                null
        );
    }
    public static CreateStudentResponse toDto(Student student) {
        return new CreateStudentResponse(
                student.getClientId(),
                student.getFirstName(),
                student.getLastName(),
                student.getStudentStatus().getStatusValue()
        );
    }
}