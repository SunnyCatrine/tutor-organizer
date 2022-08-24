package main.java.edu.catherine.tutorg.model.client.dto;

import java.util.Objects;

public class CreateStudentRequestDto {
    private String firstName;
    private String lastName;
    private String phoneNo;
    private String skype;
    private String country;
    private String city;
    private String timezone;
    private String firstSubjectBlock;
    private String secondSubjectBlock;
    private String thirdSubjectBlock;
    private String defaultPrice;
    private String defaultDurationInMinutes;
    private String firstDayOfWeek;
    private String secondDayOfWeek;
    private String thirdDayOfWeek;
    private String fourthDayOfWeek;
    private String firstDayOfWeekTime;
    private String secondDayOfWeekTime;
    private String thirdDayOfWeekTime;
    private String fourthDayOfWeekTime;
    private String firstLessonDate;
    private String lastLessonDate;

    public CreateStudentRequestDto(String firstName, String lastName, String phoneNo, String skype, String country, String city, String timezone, String firstSubjectBlock, String secondSubjectBlock, String thirdSubjectBlock, String defaultPrice, String defaultDurationInMinutes, String firstDayOfWeek, String secondDayOfWeek, String thirdDayOfWeek, String fourthDayOfWeek, String firstDayOfWeekTime, String secondDayOfWeekTime, String thirdDayOfWeekTime, String fourthDayOfWeekTime, String firstLessonDate, String lastLessonDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNo = phoneNo;
        this.skype = skype;
        this.country = country;
        this.city = city;
        this.timezone = timezone;
        this.firstSubjectBlock = firstSubjectBlock;
        this.secondSubjectBlock = secondSubjectBlock;
        this.thirdSubjectBlock = thirdSubjectBlock;
        this.defaultPrice = defaultPrice;
        this.defaultDurationInMinutes = defaultDurationInMinutes;
        this.firstDayOfWeek = firstDayOfWeek;
        this.secondDayOfWeek = secondDayOfWeek;
        this.thirdDayOfWeek = thirdDayOfWeek;
        this.fourthDayOfWeek = fourthDayOfWeek;
        this.firstDayOfWeekTime = firstDayOfWeekTime;
        this.secondDayOfWeekTime = secondDayOfWeekTime;
        this.thirdDayOfWeekTime = thirdDayOfWeekTime;
        this.fourthDayOfWeekTime = fourthDayOfWeekTime;
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

    public String getFirstSubjectBlock() {
        return firstSubjectBlock;
    }

    public void setFirstSubjectBlock(String firstSubjectBlock) {
        this.firstSubjectBlock = firstSubjectBlock;
    }

    public String getSecondSubjectBlock() {
        return secondSubjectBlock;
    }

    public void setSecondSubjectBlock(String secondSubjectBlock) {
        this.secondSubjectBlock = secondSubjectBlock;
    }

    public String getThirdSubjectBlock() {
        return thirdSubjectBlock;
    }

    public void setThirdSubjectBlock(String thirdSubjectBlock) {
        this.thirdSubjectBlock = thirdSubjectBlock;
    }

    public String getDefaultPrice() {
        return defaultPrice;
    }

    public void setDefaultPrice(String defaultPrice) {
        this.defaultPrice = defaultPrice;
    }

    public String getDefaultDurationInMinutes() {
        return defaultDurationInMinutes;
    }

    public void setDefaultDurationInMinutes(String defaultDurationInMinutes) {
        this.defaultDurationInMinutes = defaultDurationInMinutes;
    }

    public String getFirstDayOfWeek() {
        return firstDayOfWeek;
    }

    public void setFirstDayOfWeek(String firstDayOfWeek) {
        this.firstDayOfWeek = firstDayOfWeek;
    }

    public String getSecondDayOfWeek() {
        return secondDayOfWeek;
    }

    public void setSecondDayOfWeek(String secondDayOfWeek) {
        this.secondDayOfWeek = secondDayOfWeek;
    }

    public String getThirdDayOfWeek() {
        return thirdDayOfWeek;
    }

    public void setThirdDayOfWeek(String thirdDayOfWeek) {
        this.thirdDayOfWeek = thirdDayOfWeek;
    }

    public String getFourthDayOfWeek() {
        return fourthDayOfWeek;
    }

    public void setFourthDayOfWeek(String fourthDayOfWeek) {
        this.fourthDayOfWeek = fourthDayOfWeek;
    }

    public String getFirstDayOfWeekTime() {
        return firstDayOfWeekTime;
    }

    public void setFirstDayOfWeekTime(String firstDayOfWeekTime) {
        this.firstDayOfWeekTime = firstDayOfWeekTime;
    }

    public String getSecondDayOfWeekTime() {
        return secondDayOfWeekTime;
    }

    public void setSecondDayOfWeekTime(String secondDayOfWeekTime) {
        this.secondDayOfWeekTime = secondDayOfWeekTime;
    }

    public String getThirdDayOfWeekTime() {
        return thirdDayOfWeekTime;
    }

    public void setThirdDayOfWeekTime(String thirdDayOfWeekTime) {
        this.thirdDayOfWeekTime = thirdDayOfWeekTime;
    }

    public String getFourthDayOfWeekTime() {
        return fourthDayOfWeekTime;
    }

    public void setFourthDayOfWeekTime(String fourthDayOfWeekTime) {
        this.fourthDayOfWeekTime = fourthDayOfWeekTime;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CreateStudentRequestDto)) return false;
        CreateStudentRequestDto that = (CreateStudentRequestDto) o;
        return Objects.equals(getFirstName(), that.getFirstName()) &&
                Objects.equals(getLastName(), that.getLastName()) &&
                Objects.equals(getPhoneNo(), that.getPhoneNo()) &&
                Objects.equals(getSkype(), that.getSkype()) &&
                Objects.equals(getCountry(), that.getCountry()) &&
                Objects.equals(getCity(), that.getCity()) &&
                Objects.equals(getTimezone(), that.getTimezone()) &&
                Objects.equals(getFirstSubjectBlock(), that.getFirstSubjectBlock()) &&
                Objects.equals(getSecondSubjectBlock(), that.getSecondSubjectBlock()) &&
                Objects.equals(getThirdSubjectBlock(), that.getThirdSubjectBlock()) &&
                Objects.equals(getDefaultPrice(), that.getDefaultPrice()) &&
                Objects.equals(getDefaultDurationInMinutes(), that.getDefaultDurationInMinutes()) &&
                Objects.equals(getFirstDayOfWeek(), that.getFirstDayOfWeek()) &&
                Objects.equals(getSecondDayOfWeek(), that.getSecondDayOfWeek()) &&
                Objects.equals(getThirdDayOfWeek(), that.getThirdDayOfWeek()) &&
                Objects.equals(getFourthDayOfWeek(), that.getFourthDayOfWeek()) &&
                Objects.equals(getFirstDayOfWeekTime(), that.getFirstDayOfWeekTime()) &&
                Objects.equals(getSecondDayOfWeekTime(), that.getSecondDayOfWeekTime()) &&
                Objects.equals(getThirdDayOfWeekTime(), that.getThirdDayOfWeekTime()) &&
                Objects.equals(getFourthDayOfWeekTime(), that.getFourthDayOfWeekTime()) &&
                Objects.equals(getFirstLessonDate(), that.getFirstLessonDate()) &&
                Objects.equals(getLastLessonDate(), that.getLastLessonDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getLastName(), getPhoneNo(), getSkype(), getCountry(), getCity(), getTimezone(), getFirstSubjectBlock(), getSecondSubjectBlock(), getThirdSubjectBlock(), getDefaultPrice(), getDefaultDurationInMinutes(), getFirstDayOfWeek(), getSecondDayOfWeek(), getThirdDayOfWeek(), getFourthDayOfWeek(), getFirstDayOfWeekTime(), getSecondDayOfWeekTime(), getThirdDayOfWeekTime(), getFourthDayOfWeekTime(), getFirstLessonDate(), getLastLessonDate());
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
                ", firstSubjectBlock='" + firstSubjectBlock + '\'' +
                ", secondSubjectBlock='" + secondSubjectBlock + '\'' +
                ", thirdSubjectBlock='" + thirdSubjectBlock + '\'' +
                ", defaultPrice='" + defaultPrice + '\'' +
                ", defaultDurationInMinutes='" + defaultDurationInMinutes + '\'' +
                ", firstDayOfWeek='" + firstDayOfWeek + '\'' +
                ", secondDayOfWeek='" + secondDayOfWeek + '\'' +
                ", thirdDayOfWeek='" + thirdDayOfWeek + '\'' +
                ", fourthDayOfWeek='" + fourthDayOfWeek + '\'' +
                ", firstDayOfWeekTime='" + firstDayOfWeekTime + '\'' +
                ", secondDayOfWeekTime='" + secondDayOfWeekTime + '\'' +
                ", thirdDayOfWeekTime='" + thirdDayOfWeekTime + '\'' +
                ", fourthDayOfWeekTime='" + fourthDayOfWeekTime + '\'' +
                ", firstLessonDate='" + firstLessonDate + '\'' +
                ", lastLessonDate='" + lastLessonDate + '\'' +
                '}';
    }
}
