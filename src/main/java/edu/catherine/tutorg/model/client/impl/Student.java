package main.java.edu.catherine.tutorg.model.client.impl;

import main.java.edu.catherine.tutorg.model.client.*;
import main.java.edu.catherine.tutorg.model.lesson.Lesson;
import main.java.edu.catherine.tutorg.model.lesson.LessonParam;
import main.java.edu.catherine.tutorg.model.lesson.SubjectBlock;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Student extends Client {
    private List<SubjectBlock> subjects;
    private LessonParam defaultLessonParam;
    private Map<DayOfWeek, LocalTime> schedule;
    private List<Lesson> lessonList;
    private StudentStatus studentStatus;
    private LessonsPeriod lessonsPeriod;
    private Agent agent;

    public Student(String firstName, String lastName, Contact contact, Location location, LessonParam defaultLessonParam, StudentStatus studentStatus) {
        super(firstName, lastName, contact, location);
        this.defaultLessonParam = defaultLessonParam;
        this.studentStatus = studentStatus;
    }

    public Student(Integer clientId, String firstName, String lastName, Contact contact, Location location, StudentStatus studentStatus) {
        super(clientId, firstName, lastName, contact, location);
        this.studentStatus = studentStatus;
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

    public void setDefaultLessonParam(LessonParam defaultLessonParam) {
        this.defaultLessonParam = defaultLessonParam;
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
        return Objects.equals(getSubjects(), student.getSubjects()) &&
                getDefaultLessonParam().equals(student.getDefaultLessonParam()) &&
                Objects.equals(getSchedule(), student.getSchedule()) &&
                Objects.equals(getLessonList(), student.getLessonList()) &&
                getStudentStatus() == student.getStudentStatus() &&
                getLessonsPeriod().equals(student.getLessonsPeriod());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getSubjects(), getDefaultLessonParam(), getSchedule(), getLessonList(), getStudentStatus(), getLessonsPeriod());
    }

    // DONE: 30.08.2022 bad impl of toString :)
    @Override
    public String toString() {

        return "Student{"
                + super.toString()
                + "defaultLessonParam=" + defaultLessonParam +
                '}';
    }
}
