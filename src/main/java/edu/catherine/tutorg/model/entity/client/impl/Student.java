package main.java.edu.catherine.tutorg.model.entity.client.impl;

import lombok.*;
import main.java.edu.catherine.tutorg.model.entity.client.*;
import main.java.edu.catherine.tutorg.model.entity.lesson.Lesson;
import main.java.edu.catherine.tutorg.model.entity.lesson.LessonParam;
import main.java.edu.catherine.tutorg.model.entity.lesson.SubjectBlock;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;

@Builder
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
public class Student extends Client {
    private Contact contact;
    private List<SubjectBlock> subjects;
    private LessonParam defaultLessonParam;
    private Map<DayOfWeek, LocalTime> schedule;
    private List<Lesson> lessonList;
    private StudentStatus studentStatus;
    private LessonsPeriod lessonsPeriod;
    private List<Agent> agentList;

    public Student(String firstName, String lastName, Contact contact, Location location, LessonParam defaultLessonParam, StudentStatus studentStatus) {
        super(firstName, lastName, location);
        this.contact = contact;
        this.defaultLessonParam = defaultLessonParam;
        this.studentStatus = studentStatus;
    }

    public Student(Integer clientId, String firstName, String lastName, Contact contact, Location location, LessonParam defaultLessonParam, StudentStatus studentStatus) {
        super(clientId, firstName, lastName, location);
        this.contact = contact;
        this.defaultLessonParam = defaultLessonParam;
        this.studentStatus = studentStatus;
    }

    @Override
    public String toString() {

        return "Student{"
                + super.toString()
                + "contact=" + contact
                + "defaultLessonParam=" + defaultLessonParam
                + "status=" + studentStatus
                + '}';
    }
}
