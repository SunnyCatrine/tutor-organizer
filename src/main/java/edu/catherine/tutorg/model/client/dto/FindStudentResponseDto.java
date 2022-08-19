package main.java.edu.catherine.tutorg.model.client.dto;

import main.java.edu.catherine.tutorg.model.client.StudentStatus;
import main.java.edu.catherine.tutorg.model.lesson.SubjectBlock;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class FindStudentResponseDto {
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
    private StudentStatus status;
    private String agentFirstName;
    private String agentLastName;
    private String agentPhoneNo;
    private String agentCountry;
    private String agentCity;
    private String agentTimezone;

    public FindStudentResponseDto(String firstName, String lastName, String phoneNo, String skype, String country, String city, String timezone, List<SubjectBlock> subjects, Integer defaultPrice, Double defaultDuration, Map<DayOfWeek, LocalTime> schedule, LocalDate firstLessonDate, LocalDate lastLessonDate, StudentStatus status, String agentFirstName, String agentLastName, String agentPhoneNo, String agentCountry, String agentCity, String agentTimezone) {
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
        this.status = status;
        this.agentFirstName = agentFirstName;
        this.agentLastName = agentLastName;
        this.agentPhoneNo = agentPhoneNo;
        this.agentCountry = agentCountry;
        this.agentCity = agentCity;
        this.agentTimezone = agentTimezone;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public String getSkype() {
        return skype;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getTimezone() {
        return timezone;
    }

    public List<SubjectBlock> getSubjects() {
        return subjects;
    }

    public Integer getDefaultPrice() {
        return defaultPrice;
    }

    public Double getDefaultDuration() {
        return defaultDuration;
    }

    public Map<DayOfWeek, LocalTime> getSchedule() {
        return schedule;
    }

    public LocalDate getFirstLessonDate() {
        return firstLessonDate;
    }

    public LocalDate getLastLessonDate() {
        return lastLessonDate;
    }

    public StudentStatus getStatus() {
        return status;
    }

    public String getAgentFirstName() {
        return agentFirstName;
    }

    public String getAgentLastName() {
        return agentLastName;
    }

    public String getAgentPhoneNo() {
        return agentPhoneNo;
    }

    public String getAgentCountry() {
        return agentCountry;
    }

    public String getAgentCity() {
        return agentCity;
    }

    public String getAgentTimezone() {
        return agentTimezone;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public void setSubjects(List<SubjectBlock> subjects) {
        this.subjects = subjects;
    }

    public void setDefaultPrice(Integer defaultPrice) {
        this.defaultPrice = defaultPrice;
    }

    public void setDefaultDuration(Double defaultDuration) {
        this.defaultDuration = defaultDuration;
    }

    public void setSchedule(Map<DayOfWeek, LocalTime> schedule) {
        this.schedule = schedule;
    }

    public void setFirstLessonDate(LocalDate firstLessonDate) {
        this.firstLessonDate = firstLessonDate;
    }

    public void setLastLessonDate(LocalDate lastLessonDate) {
        this.lastLessonDate = lastLessonDate;
    }

    public void setStatus(StudentStatus status) {
        this.status = status;
    }

    public void setAgentFirstName(String agentFirstName) {
        this.agentFirstName = agentFirstName;
    }

    public void setAgentLastName(String agentLastName) {
        this.agentLastName = agentLastName;
    }

    public void setAgentPhoneNo(String agentPhoneNo) {
        this.agentPhoneNo = agentPhoneNo;
    }

    public void setAgentCountry(String agentCountry) {
        this.agentCountry = agentCountry;
    }

    public void setAgentCity(String agentCity) {
        this.agentCity = agentCity;
    }

    public void setAgentTimezone(String agentTimezone) {
        this.agentTimezone = agentTimezone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FindStudentResponseDto)) return false;
        FindStudentResponseDto that = (FindStudentResponseDto) o;
        return getFirstName().equals(that.getFirstName()) &&
                Objects.equals(getLastName(), that.getLastName()) &&
                Objects.equals(getPhoneNo(), that.getPhoneNo()) &&
                getSkype().equals(that.getSkype()) &&
                getCountry().equals(that.getCountry()) &&
                getCity().equals(that.getCity()) &&
                getTimezone().equals(that.getTimezone()) &&
                getSubjects().equals(that.getSubjects()) &&
                getDefaultPrice().equals(that.getDefaultPrice()) &&
                getDefaultDuration().equals(that.getDefaultDuration()) &&
                getSchedule().equals(that.getSchedule()) &&
                getFirstLessonDate().equals(that.getFirstLessonDate()) &&
                Objects.equals(getLastLessonDate(), that.getLastLessonDate()) &&
                getStatus() == that.getStatus() &&
                Objects.equals(getAgentFirstName(), that.getAgentFirstName()) &&
                Objects.equals(getAgentLastName(), that.getAgentLastName()) &&
                Objects.equals(getAgentPhoneNo(), that.getAgentPhoneNo()) &&
                Objects.equals(getAgentCountry(), that.getAgentCountry()) &&
                Objects.equals(getAgentCity(), that.getAgentCity()) &&
                Objects.equals(getAgentTimezone(), that.getAgentTimezone());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getLastName(), getPhoneNo(), getSkype(), getCountry(), getCity(), getTimezone(), getSubjects(), getDefaultPrice(), getDefaultDuration(), getSchedule(), getFirstLessonDate(), getLastLessonDate(), getStatus(), getAgentFirstName(), getAgentLastName(), getAgentPhoneNo(), getAgentCountry(), getAgentCity(), getAgentTimezone());
    }

    @Override
    public String toString() {
        return "FindStudentResponseDto{" +
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
                ", status=" + status +
                ", agentFirstName='" + agentFirstName + '\'' +
                ", agentLastName='" + agentLastName + '\'' +
                ", agentPhoneNo='" + agentPhoneNo + '\'' +
                ", agentCountry='" + agentCountry + '\'' +
                ", agentCity='" + agentCity + '\'' +
                ", agentTimezone='" + agentTimezone + '\'' +
                '}';
    }
}
