package main.java.edu.catherine.tutorg.model.client.ext;

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

    public Student(Integer clientId, String firstName, String lastName, Contact contact, Location location, StudentStatus studentStatus) {
        super(clientId, firstName, lastName, contact, location);
        this.studentStatus = studentStatus;
    }

    public Student(String firstName, String lastName, Contact contact, Location location, List<SubjectBlock> subjects, LessonParam defaultLessonParam, Map<DayOfWeek, LocalTime> schedule, List<Lesson> lessonList, StudentStatus studentStatus, LessonsPeriod lessonsPeriod) {
        super(firstName, lastName, contact, location);
        this.subjects = subjects;
        this.defaultLessonParam = defaultLessonParam;
        this.schedule = schedule;
        this.lessonList = lessonList;
        this.studentStatus = studentStatus;
        this.lessonsPeriod = lessonsPeriod;
        this.agent = agent;
    }

    public Student(String firstName, String lastName, Contact contact, Location location, LessonParam defaultLessonParam) {
        super(firstName, lastName, contact, location);
        this.defaultLessonParam = defaultLessonParam;
    }

    public Student(Integer clientId, String firstName, String lastName, Contact contact, StudentStatus studentStatus) {
        super(clientId, firstName, lastName, contact);
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

    @Override
    public String toString() {

        return super.toString() + "Student{" +
                "defaultLessonParam=" + defaultLessonParam +
                '}';
    }
}
