package main.java.edu.catherine.tutorg.mapper;

import main.java.edu.catherine.tutorg.model.client.Contact;
import main.java.edu.catherine.tutorg.model.client.Location;
import main.java.edu.catherine.tutorg.model.client.StudentStatus;
import main.java.edu.catherine.tutorg.model.dto.StudentRequest;
import main.java.edu.catherine.tutorg.model.client.impl.Student;
import main.java.edu.catherine.tutorg.model.dto.StudentResponse;
import main.java.edu.catherine.tutorg.model.lesson.LessonParam;

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