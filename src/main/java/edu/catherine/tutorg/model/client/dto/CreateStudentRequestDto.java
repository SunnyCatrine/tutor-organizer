package main.java.edu.catherine.tutorg.model.client.dto;

import main.java.edu.catherine.tutorg.model.lesson.SubjectBlock;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class CreateStudentRequestDto {
    private String firstName;
    private String lastName;
    private String phoneNo;
    private String skype;
    private String country;
    private String city;
    private String timezone;
    private List<SubjectBlock> subjects;
    private Integer defaultPrice;
    private Double defaultDuration;
    private Map<DayOfWeek, LocalTime> schedule;
    private LocalDate firstLessonDate;
    private LocalDate lastLessonDate;

    public CreateStudentRequestDto(String firstName, String lastName, String phoneNo, String skype, String country, String city, String timezone, List<SubjectBlock> subjects, Integer defaultPrice, Double defaultDuration, Map<DayOfWeek, LocalTime> schedule, LocalDate firstLessonDate, LocalDate lastLessonDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNo = phoneNo;
        this.skype = skype;
        this.country = country;
        this.city = city;
        this.timezone = timezone;
        this.subjects = subjects;
        this.defaultPrice = defaultPrice;
        this.defaultDuration = defaultDuration;
        this.schedule = schedule;
        this.firstLessonDate = firstLessonDate;
        this.lastLessonDate = lastLessonDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public List<SubjectBlock> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<SubjectBlock> subjects) {
        this.subjects = subjects;
    }

    public Integer getDefaultPrice() {
        return defaultPrice;
    }

    public void setDefaultPrice(Integer defaultPrice) {
        this.defaultPrice = defaultPrice;
    }

    public Double getDefaultDuration() {
        return defaultDuration;
    }

    public void setDefaultDuration(Double defaultDuration) {
        this.defaultDuration = defaultDuration;
    }

    public Map<DayOfWeek, LocalTime> getSchedule() {
        return schedule;
    }

    public void setSchedule(Map<DayOfWeek, LocalTime> schedule) {
        this.schedule = schedule;
    }

    public LocalDate getFirstLessonDate() {
        return firstLessonDate;
    }

    public void setFirstLessonDate(LocalDate firstLessonDate) {
        this.firstLessonDate = firstLessonDate;
    }

    public LocalDate getLastLessonDate() {
        return lastLessonDate;
    }

    public void setLastLessonDate(LocalDate lastLessonDate) {
        this.lastLessonDate = lastLessonDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CreateStudentRequestDto)) return false;
        CreateStudentRequestDto that = (CreateStudentRequestDto) o;
        return getFirstName().equals(that.getFirstName()) &&
                getLastName().equals(that.getLastName()) &&
                Objects.equals(getPhoneNo(), that.getPhoneNo()) &&
                getSkype().equals(that.getSkype()) &&
                getCountry().equals(that.getCountry()) &&
                Objects.equals(getCity(), that.getCity()) &&
                getTimezone().equals(that.getTimezone()) &&
                getSubjects().equals(that.getSubjects()) &&
                getDefaultPrice().equals(that.getDefaultPrice()) &&
                getDefaultDuration().equals(that.getDefaultDuration()) &&
                getSchedule().equals(that.getSchedule()) &&
                getFirstLessonDate().equals(that.getFirstLessonDate()) &&
                Objects.equals(getLastLessonDate(), that.getLastLessonDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getLastName(), getPhoneNo(), getSkype(), getCountry(), getCity(), getTimezone(), getSubjects(), getDefaultPrice(), getDefaultDuration(), getSchedule(), getFirstLessonDate(), getLastLessonDate());
    }

    @Override
    public String toString() {
        return "CreateStudentRequestDto{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", skype='" + skype + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", timezone='" + timezone + '\'' +
                ", subjects=" + subjects +
                ", defaultPrice=" + defaultPrice +
                ", defaultDuration=" + defaultDuration +
                ", schedule=" + schedule +
                ", firstLessonDate=" + firstLessonDate +
                ", lastLessonDate=" + lastLessonDate +
                '}';
    }
}
