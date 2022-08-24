package main.java.edu.catherine.tutorg.mapper;

import main.java.edu.catherine.tutorg.model.Schedule;
import main.java.edu.catherine.tutorg.model.client.Contact;
import main.java.edu.catherine.tutorg.model.client.LessonsPeriod;
import main.java.edu.catherine.tutorg.model.client.Location;
import main.java.edu.catherine.tutorg.model.client.StudentStatus;
import main.java.edu.catherine.tutorg.model.client.dto.CreateStudentRequestDto;
import main.java.edu.catherine.tutorg.model.client.dto.CreateStudentResponseDto;
import main.java.edu.catherine.tutorg.model.client.ext.Student;
import main.java.edu.catherine.tutorg.model.lesson.LessonParam;

public class CreateStudentMapper {

    public static Student toEntity(CreateStudentRequestDto studentRequestDto) {
        Contact contact = new Contact(
                studentRequestDto.getPhoneNo(),
                studentRequestDto.getSkype()
        );

        Location location = new Location(
                studentRequestDto.getCountry(),
                studentRequestDto.getCity(),
                studentRequestDto.getTimezone()
        );

        LessonParam defaultLessonParam = new LessonParam(
                studentRequestDto.getDefaultPrice(),
                studentRequestDto.getDefaultDurationInMinutes()
        );

        Schedule schedule = new Schedule(studentRequestDto.getSchedule());

        LessonsPeriod lessonsPeriod = new LessonsPeriod(
                studentRequestDto.getFirstLessonDate(),
                studentRequestDto.getLastLessonDate()
        );

        return new Student(
                studentRequestDto.getFirstName(),
                studentRequestDto.getLastName(),
                contact,
                location,
                studentRequestDto.getSubjects(),
                defaultLessonParam,
                schedule,
                null,
                StudentStatus.ACTIVE,
                lessonsPeriod
        );
    }

    public static CreateStudentResponseDto toDto(Student student) {
        return new CreateStudentResponseDto(
                student.getClientId(),
                student.getFirstName(),
                student.getLastName()
        );
    }
}
