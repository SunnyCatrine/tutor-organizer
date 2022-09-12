package main.java.edu.catherine.tutorg.model.entity.client.impl;

import main.java.edu.catherine.tutorg.model.entity.client.*;
import main.java.edu.catherine.tutorg.model.entity.lesson.Lesson;
import main.java.edu.catherine.tutorg.model.entity.lesson.LessonParam;
import main.java.edu.catherine.tutorg.model.entity.lesson.SubjectBlock;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Student extends Client {
    private Contact contact;
    private List<SubjectBlock> subjects;
    private LessonParam defaultLessonParam;
    private Map<DayOfWeek, LocalTime> schedule;
    private List<Lesson> lessonList;
    private StudentStatus studentStatus;
    private LessonsPeriod lessonsPeriod;
    private Agent agent;

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

    public Contact getContact() {
        return contact;
    }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    public List<SubjectBlock> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<SubjectBlock> subjects) {
        this.subjects = subjects;
    }


    public LessonParam getDefaultLessonParam() {
        return defaultLessonParam;
    }

    public Map<DayOfWeek, LocalTime> getSchedule() {
        return schedule;
    }

    public void setSchedule(Map<DayOfWeek, LocalTime> schedule) {
        this.schedule = schedule;
    }

    public List<Lesson> getLessonList() {
        return lessonList;
    }

    public void setLessonList(List<Lesson> lessonList) {
        this.lessonList = lessonList;
    }

    public StudentStatus getStudentStatus() {
        return studentStatus;
    }

    public void setStudentStatus(StudentStatus studentStatus) {
        this.studentStatus = studentStatus;
    }

    public LessonsPeriod getLessonsPeriod() {
        return lessonsPeriod;
    }

    public void setLessonsPeriod(LessonsPeriod lessonsPeriod) {
        this.lessonsPeriod = lessonsPeriod;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return Objects.equals(contact, student.contact) &&
                Objects.equals(getSubjects(), student.getSubjects()) &&
                Objects.equals(getDefaultLessonParam(), student.getDefaultLessonParam()) &&
                Objects.equals(getSchedule(), student.getSchedule()) &&
                Objects.equals(getLessonList(), student.getLessonList()) &&
                getStudentStatus() == student.getStudentStatus() &&
                Objects.equals(getLessonsPeriod(), student.getLessonsPeriod()) &&
                Objects.equals(getAgent(), student.getAgent());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), contact, getSubjects(), getDefaultLessonParam(), getSchedule(), getLessonList(), getStudentStatus(), getLessonsPeriod(), getAgent());
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
