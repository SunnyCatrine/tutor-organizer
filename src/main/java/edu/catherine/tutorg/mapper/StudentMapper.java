package main.java.edu.catherine.tutorg.mapper;

import main.java.edu.catherine.tutorg.model.entity.client.Contact;
import main.java.edu.catherine.tutorg.model.entity.client.Location;
import main.java.edu.catherine.tutorg.model.entity.client.StudentStatus;
import main.java.edu.catherine.tutorg.model.dto.StudentRequest;
import main.java.edu.catherine.tutorg.model.entity.client.impl.Student;
import main.java.edu.catherine.tutorg.model.dto.StudentResponse;
import main.java.edu.catherine.tutorg.model.entity.lesson.LessonParam;

public final class StudentMapper {

    public static Student toCreateEntity(StudentRequest studentRequest) {
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

        return new Student(
                studentRequest.getFirstName(),
                studentRequest.getLastName(),
                contact,
                location,
                defaultLessonParam,
                StudentStatus.valueOf(studentRequest.getStudentStatus())
        );
    }

    public static Student toUpdateEntity(StudentRequest studentRequest) {
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

    public static StudentResponse toResponse(Student student) {
        return StudentResponse.builder()
                .id(student.getClientId().toString())
                .firstName(student.getFirstName())
                .lastName(student.getLastName())
                .status(student.getStudentStatus().getStatusValue())
                .phoneNo(student.getContact().getPhoneNo())
                .skype(student.getContact().getSkype())
                .country(student.getLocation().getCountry())
                .city(student.getLocation().getCity())
                .timezone(student.getLocation().getTimezone())
                .defaultPrice(student.getDefaultLessonParam().getPrice().toString())
                .defaultDuration(student.getDefaultLessonParam().getDuration().toString())
                .build();
    }
}