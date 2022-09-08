package main.java.edu.catherine.tutorg.mapper;

import main.java.edu.catherine.tutorg.model.entity.client.Contact;
import main.java.edu.catherine.tutorg.model.entity.client.Location;
import main.java.edu.catherine.tutorg.model.entity.client.StudentStatus;
import main.java.edu.catherine.tutorg.model.dto.StudentRequest;
import main.java.edu.catherine.tutorg.model.entity.client.impl.Student;
import main.java.edu.catherine.tutorg.model.dto.StudentResponse;
import main.java.edu.catherine.tutorg.model.entity.lesson.LessonParam;

public class StudentMapper {

    public static Student toEntity(StudentRequest studentRequest) {
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
                studentRequest.getDefaultPrice() == null
                        ? null
                        : Integer.parseInt(studentRequest.getDefaultPrice()),
                studentRequest.getDefaultDurationInMinutes() == null
                        ? null
                        : Integer.parseInt(studentRequest.getDefaultDurationInMinutes())
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
                studentStatus
        );
    }
    public static StudentResponse toDto(Student student) {
        return new StudentResponse(
                student.getClientId().toString(),
                student.getFirstName(),
                student.getLastName(),
                student.getStudentStatus().getStatusValue(),
                student.getContact().getPhoneNo(),
                student.getContact().getSkype(),
                student.getLocation().getCountry(),
                student.getLocation().getCity(),
                student.getLocation().getTimezone(),
                student.getDefaultLessonParam().getPrice().toString(),
                student.getDefaultLessonParam().getDuration().toString()
        );
    }
}