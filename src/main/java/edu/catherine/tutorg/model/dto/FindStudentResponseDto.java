package main.java.edu.catherine.tutorg.model.dto;

import java.util.List;
import java.util.Objects;

public class FindStudentResponseDto {
    private Integer id;
    private String firstName;
    private String lastName;
    private String status;
    private String phoneNo;
    private String skype;
    private String country;
    private String city;
    private String timezone;
    private List<String> subjects;
    private String defaultPrice;
    private String defaultDuration;
    private List<String> scheduleUnits;
    private String firstLessonDate;
    private String lastLessonDate;
    private String agentFirstName;
    private String agentLastName;
    private String agentPhoneNo;
    private String agentCountry;
    private String agentCity;
    private String agentTimezone;

    public FindStudentResponseDto(Integer id, String firstName, String lastName, String status) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.status = status;
    }

    public FindStudentResponseDto(String firstName, String lastName, String phoneNo, String skype, String country, String city, String timezone, List<String> subjects, String defaultPrice, String defaultDuration, List<String> scheduleUnits, String firstLessonDate, String lastLessonDate, String status, String agentFirstName, String agentLastName, String agentPhoneNo, String agentCountry, String agentCity, String agentTimezone) {
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
        this.scheduleUnits = scheduleUnits;
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

    public List<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }

    public String getDefaultPrice() {
        return defaultPrice;
    }

    public void setDefaultPrice(String defaultPrice) {
        this.defaultPrice = defaultPrice;
    }

    public String getDefaultDuration() {
        return defaultDuration;
    }

    public void setDefaultDuration(String defaultDuration) {
        this.defaultDuration = defaultDuration;
    }

    public List<String> getScheduleUnits() {
        return scheduleUnits;
    }

    public void setScheduleUnits(List<String> scheduleUnits) {
        this.scheduleUnits = scheduleUnits;
    }

    public String getFirstLessonDate() {
        return firstLessonDate;
    }

    public void setFirstLessonDate(String firstLessonDate) {
        this.firstLessonDate = firstLessonDate;
    }

    public String getLastLessonDate() {
        return lastLessonDate;
    }

    public void setLastLessonDate(String lastLessonDate) {
        this.lastLessonDate = lastLessonDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAgentFirstName() {
        return agentFirstName;
    }

    public void setAgentFirstName(String agentFirstName) {
        this.agentFirstName = agentFirstName;
    }

    public String getAgentLastName() {
        return agentLastName;
    }

    public void setAgentLastName(String agentLastName) {
        this.agentLastName = agentLastName;
    }

    public String getAgentPhoneNo() {
        return agentPhoneNo;
    }

    public void setAgentPhoneNo(String agentPhoneNo) {
        this.agentPhoneNo = agentPhoneNo;
    }

    public String getAgentCountry() {
        return agentCountry;
    }

    public void setAgentCountry(String agentCountry) {
        this.agentCountry = agentCountry;
    }

    public String getAgentCity() {
        return agentCity;
    }

    public void setAgentCity(String agentCity) {
        this.agentCity = agentCity;
    }

    public String getAgentTimezone() {
        return agentTimezone;
    }

    public void setAgentTimezone(String agentTimezone) {
        this.agentTimezone = agentTimezone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FindStudentResponseDto)) return false;
        FindStudentResponseDto that = (FindStudentResponseDto) o;
        return Objects.equals(getFirstName(), that.getFirstName()) &&
                Objects.equals(getLastName(), that.getLastName()) &&
                Objects.equals(getPhoneNo(), that.getPhoneNo()) &&
                Objects.equals(getSkype(), that.getSkype()) &&
                Objects.equals(getCountry(), that.getCountry()) &&
                Objects.equals(getCity(), that.getCity()) &&
                Objects.equals(getTimezone(), that.getTimezone()) &&
                Objects.equals(getSubjects(), that.getSubjects()) &&
                Objects.equals(getDefaultPrice(), that.getDefaultPrice()) &&
                Objects.equals(getDefaultDuration(), that.getDefaultDuration()) &&
                Objects.equals(getScheduleUnits(), that.getScheduleUnits()) &&
                Objects.equals(getFirstLessonDate(), that.getFirstLessonDate()) &&
                Objects.equals(getLastLessonDate(), that.getLastLessonDate()) &&
                Objects.equals(getStatus(), that.getStatus()) &&
                Objects.equals(getAgentFirstName(), that.getAgentFirstName()) &&
                Objects.equals(getAgentLastName(), that.getAgentLastName()) &&
                Objects.equals(getAgentPhoneNo(), that.getAgentPhoneNo()) &&
                Objects.equals(getAgentCountry(), that.getAgentCountry()) &&
                Objects.equals(getAgentCity(), that.getAgentCity()) &&
                Objects.equals(getAgentTimezone(), that.getAgentTimezone());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getLastName(), getPhoneNo(), getSkype(), getCountry(), getCity(), getTimezone(), getSubjects(), getDefaultPrice(), getDefaultDuration(), getScheduleUnits(), getFirstLessonDate(), getLastLessonDate(), getStatus(), getAgentFirstName(), getAgentLastName(), getAgentPhoneNo(), getAgentCountry(), getAgentCity(), getAgentTimezone());
    }

    @Override
    public String toString() {
        return "FindStudentResponseDto{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", status='" + status + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", skype='" + skype + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", timezone='" + timezone + '\'' +
                ", subjects=" + subjects +
                ", defaultPrice='" + defaultPrice + '\'' +
                ", defaultDuration='" + defaultDuration + '\'' +
                ", scheduleUnits=" + scheduleUnits +
                ", firstLessonDate='" + firstLessonDate + '\'' +
                ", lastLessonDate='" + lastLessonDate + '\'' +
                ", agentFirstName='" + agentFirstName + '\'' +
                ", agentLastName='" + agentLastName + '\'' +
                ", agentPhoneNo='" + agentPhoneNo + '\'' +
                ", agentCountry='" + agentCountry + '\'' +
                ", agentCity='" + agentCity + '\'' +
                ", agentTimezone='" + agentTimezone + '\'' +
                '}';
    }
}
