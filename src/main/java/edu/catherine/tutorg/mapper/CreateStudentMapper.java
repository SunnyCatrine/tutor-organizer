package main.java.edu.catherine.tutorg.mapper;

import main.java.edu.catherine.tutorg.model.client.Contact;
import main.java.edu.catherine.tutorg.model.client.LessonsPeriod;
import main.java.edu.catherine.tutorg.model.client.Location;
import main.java.edu.catherine.tutorg.model.client.StudentStatus;
import main.java.edu.catherine.tutorg.model.dto.CreateStudentRequestDto;
import main.java.edu.catherine.tutorg.model.dto.CreateStudentResponseDto;
import main.java.edu.catherine.tutorg.model.client.impl.Student;
import main.java.edu.catherine.tutorg.model.lesson.LessonParam;
import main.java.edu.catherine.tutorg.model.lesson.SubjectBlock;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
                Integer.parseInt(studentRequestDto.getDefaultPrice()),
                Integer.parseInt(studentRequestDto.getDefaultDurationInMinutes())
        );

        Map<DayOfWeek, LocalTime> schedule = new HashMap<>();
        if (studentRequestDto.getFirstDayOfWeek() != null && studentRequestDto.getFirstDayOfWeek() != null) {
            schedule.put(DayOfWeek.valueOf(studentRequestDto.getFirstDayOfWeek()), LocalTime.parse(studentRequestDto.getFirstDayOfWeekTime()));
        }
        if (studentRequestDto.getSecondDayOfWeek() != null && studentRequestDto.getSecondDayOfWeekTime() != null) {
            schedule.put(DayOfWeek.valueOf(studentRequestDto.getSecondDayOfWeek()), LocalTime.parse(studentRequestDto.getSecondDayOfWeekTime()));
        }
        if (studentRequestDto.getThirdDayOfWeek() != null && studentRequestDto.getThirdDayOfWeekTime() != null) {
            schedule.put(DayOfWeek.valueOf(studentRequestDto.getThirdDayOfWeek()), LocalTime.parse(studentRequestDto.getFirstDayOfWeekTime()));
        }
        if (studentRequestDto.getFourthDayOfWeek() != null && studentRequestDto.getFourthDayOfWeekTime() != null) {
            schedule.put(DayOfWeek.valueOf(studentRequestDto.getFourthDayOfWeek()), LocalTime.parse(studentRequestDto.getFourthDayOfWeekTime()));
        }


        LessonsPeriod lessonsPeriod = new LessonsPeriod(
                LocalDate.parse(studentRequestDto.getFirstLessonDate()),
                LocalDate.parse(studentRequestDto.getLastLessonDate())
        );

        List<SubjectBlock> subjectBlocks = new ArrayList<>();
        if (studentRequestDto.getFirstSubjectBlock() != null) {
            subjectBlocks.add(SubjectBlock.valueOf(studentRequestDto.getFirstSubjectBlock()));
        }
        if (studentRequestDto.getSecondSubjectBlock() != null) {
            subjectBlocks.add(SubjectBlock.valueOf(studentRequestDto.getSecondSubjectBlock()));
        }
        if (studentRequestDto.getThirdSubjectBlock() != null) {
            subjectBlocks.add(SubjectBlock.valueOf(studentRequestDto.getThirdSubjectBlock()));
        }

        return new Student(
                studentRequestDto.getFirstName(),
                studentRequestDto.getLastName(),
                contact,
                location,
                subjectBlocks,
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