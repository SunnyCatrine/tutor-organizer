package main.java.edu.catherine.tutorg.model.xml;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import main.java.edu.catherine.tutorg.model.entity.client.*;
import main.java.edu.catherine.tutorg.model.entity.client.impl.Agent;
import main.java.edu.catherine.tutorg.model.entity.lesson.Lesson;
import main.java.edu.catherine.tutorg.model.entity.lesson.LessonParam;
import main.java.edu.catherine.tutorg.model.entity.lesson.SubjectBlock;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@XmlRootElement(name = "student")
public class StudentXml {
    private Integer id;
    private String firstname;
    private String lastname;
    private Location location;
    private Contact contact;
    private LessonParam defaultLessonParam;
    private StudentStatus studentStatus;
    private LessonsPeriod lessonsPeriod;
//    private List<Agent> agentList;

    public StudentXml() {
    }

    public StudentXml(Integer id,
                      String firstname,
                      String lastname,
                      StudentStatus studentStatus,
                      Location location,
                      Contact contact,
                      LessonParam defaultLessonParam,
                      LessonsPeriod lessonsPeriod) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.studentStatus = studentStatus;
        this.location = location;
        this.contact = contact;
        this.defaultLessonParam = defaultLessonParam;
        this.lessonsPeriod = lessonsPeriod;
    }

//    public StudentXml(Integer id, String firstname, String lastname, Location location, Contact contact, List<SubjectBlock> subjects, LessonParam defaultLessonParam, Map<DayOfWeek, LocalTime> schedule, List<Lesson> lessonList, StudentStatus studentStatus, LessonsPeriod lessonsPeriod, List<Agent> agentList) {
//        this.id = id;
//        this.firstname = firstname;
//        this.lastname = lastname;
//        this.location = location;
//        this.contact = contact;
//        this.subjects = subjects;
//        this.defaultLessonParam = defaultLessonParam;
//        this.schedule = schedule;
//        this.lessonList = lessonList;
//        this.studentStatus = studentStatus;
//        this.lessonsPeriod = lessonsPeriod;
//        this.agentList = agentList;
//    }

//    public StudentXml(Integer id, String firstname, String lastname, StudentStatus studentStatus, Location location, Contact contact, LessonParam defaultLessonParam, LessonsPeriod lessonsPeriod, List<Agent> agentList) {
//        this.id = id;
//        this.firstname = firstname;
//        this.lastname = lastname;
//        this.studentStatus = studentStatus;
//        this.location = location;
//        this.contact = contact;
//        this.defaultLessonParam = defaultLessonParam;
//        this.lessonsPeriod = lessonsPeriod;
//        this.agentList = agentList;
//    }

    public Integer getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public Location getLocation() {
        return location;
    }

    public Contact getContact() {
        return contact;
    }

    public LessonParam getDefaultLessonParam() {
        return defaultLessonParam;
    }
    public StudentStatus getStudentStatus() {
        return studentStatus;
    }

    public LessonsPeriod getLessonsPeriod() {
        return lessonsPeriod;
    }

//    public List<Agent> getAgentList() {
//        return agentList;
//    }

    @XmlElement
    public void setId(Integer id) {
        this.id = id;
    }

    @XmlElement
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @XmlElement
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @XmlElement
    public void setLocation(Location location) {
        this.location = location;
    }

    @XmlElement
    public void setContact(Contact contact) {
        this.contact = contact;
    }


    @XmlElement
    public void setDefaultLessonParam(LessonParam defaultLessonParam) {
        this.defaultLessonParam = defaultLessonParam;
    }


    @XmlElement
    public void setStudentStatus(StudentStatus studentStatus) {
        this.studentStatus = studentStatus;
    }

    @XmlElement
    public void setLessonsPeriod(LessonsPeriod lessonsPeriod) {
        this.lessonsPeriod = lessonsPeriod;
    }

//    @XmlElement
//    public void setAgentList(List<Agent> agentList) {
//        this.agentList = agentList;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof StudentXml)) return false;
//        StudentXml that = (StudentXml) o;
//        return Objects.equals(getId(), that.getId()) &&
//                Objects.equals(getFirstname(), that.getFirstname()) &&
//                Objects.equals(getLastname(), that.getLastname()) &&
//                Objects.equals(getLocation(), that.getLocation()) &&
//                Objects.equals(getContact(), that.getContact()) &&
//                Objects.equals(getSubjects(), that.getSubjects()) &&
//                Objects.equals(getDefaultLessonParam(), that.getDefaultLessonParam()) &&
//                Objects.equals(getSchedule(), that.getSchedule()) &&
//                Objects.equals(getLessonList(), that.getLessonList()) &&
//                getStudentStatus() == that.getStudentStatus() &&
//                Objects.equals(getLessonsPeriod(), that.getLessonsPeriod()) &&
//                Objects.equals(getAgentList(), that.getAgentList());
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(getId(), getFirstname(), getLastname(), getLocation(), getContact(), getSubjects(), getDefaultLessonParam(), getSchedule(), getLessonList(), getStudentStatus(), getLessonsPeriod(), getAgentList());
//    }
//
//    @Override
//    public String toString() {
//        return "StudentXml{" +
//                "id=" + id +
//                ", firstname='" + firstname + '\'' +
//                ", lastname='" + lastname + '\'' +
//                ", location=" + location +
//                ", contact=" + contact +
//                ", subjects=" + subjects +
//                ", defaultLessonParam=" + defaultLessonParam +
//                ", schedule=" + schedule +
//                ", lessonList=" + lessonList +
//                ", studentStatus=" + studentStatus +
//                ", lessonsPeriod=" + lessonsPeriod +
//                ", agentList=" + agentList +
//                '}';
//    }
}
