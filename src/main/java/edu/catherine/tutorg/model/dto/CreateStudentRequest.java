package main.java.edu.catherine.tutorg.model.dto;

import java.util.Objects;

public class CreateStudentRequest {
    private String firstName;
    private String lastName;
    private String phoneNo;
    private String skype;
    private String country;
    private String city;
    private String timezone;
    private String defaultPrice;
    private String defaultDurationInMinutes;
    private String studentStatus;

    public CreateStudentRequest(String firstName,
                                String lastName,
                                String phoneNo,
                                String skype,
                                String country,
                                String city,
                                String timezone,
                                String defaultPrice,
                                String defaultDurationInMinutes,
                                String studentStatus) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNo = phoneNo;
        this.skype = skype;
        this.country = country;
        this.city = city;
        this.timezone = timezone;
        this.defaultPrice = defaultPrice;
        this.defaultDurationInMinutes = defaultDurationInMinutes;
        this.studentStatus = studentStatus;
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

    public String getDefaultPrice() {
        return defaultPrice;
    }

    public String getDefaultDurationInMinutes() {
        return defaultDurationInMinutes;
    }

    public String getStudentStatus() {
        return studentStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CreateStudentRequest)) return false;
        CreateStudentRequest that = (CreateStudentRequest) o;
        return Objects.equals(getFirstName(), that.getFirstName()) &&
                Objects.equals(getLastName(), that.getLastName()) &&
                Objects.equals(getPhoneNo(), that.getPhoneNo()) &&
                Objects.equals(getSkype(), that.getSkype()) &&
                Objects.equals(getCountry(), that.getCountry()) &&
                Objects.equals(getCity(), that.getCity()) &&
                Objects.equals(getTimezone(), that.getTimezone()) &&
                Objects.equals(getDefaultPrice(), that.getDefaultPrice()) &&
                Objects.equals(getDefaultDurationInMinutes(), that.getDefaultDurationInMinutes()) &&
                Objects.equals(getStudentStatus(), that.getStudentStatus());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getLastName(), getPhoneNo(), getSkype(), getCountry(), getCity(), getTimezone(), getDefaultPrice(), getDefaultDurationInMinutes(), getStudentStatus());
    }

    @Override
    public String toString() {
        return "CreateStudentRequest{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", skype='" + skype + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", timezone='" + timezone + '\'' +
                ", defaultPrice='" + defaultPrice + '\'' +
                ", defaultDurationInMinutes='" + defaultDurationInMinutes + '\'' +
                ", studentStatus='" + studentStatus + '\'' +
                '}';
    }
}
