package main.java.edu.catherine.tutorg.model.dto;

import java.util.Objects;

public class StudentResponse {
    private String id;
    private String firstName;
    private String lastName;
    private String status;
    private String phoneNo;
    private String skype;
    private String country;
    private String city;
    private String timezone;
    private String defaultPrice;
    private String defaultDuration;

    public StudentResponse(String id,
                           String firstName,
                           String lastName,
                           String status,
                           String phoneNo,
                           String skype,
                           String country,
                           String city,
                           String timezone,
                           String defaultPrice,
                           String defaultDuration) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.status = status;
        this.phoneNo = phoneNo;
        this.skype = skype;
        this.country = country;
        this.city = city;
        this.timezone = timezone;
        this.defaultPrice = defaultPrice;
        this.defaultDuration = defaultDuration;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getStatus() {
        return status;
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

    public String getDefaultDuration() {
        return defaultDuration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StudentResponse)) return false;
        StudentResponse that = (StudentResponse) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getFirstName(), that.getFirstName()) &&
                Objects.equals(getLastName(), that.getLastName()) &&
                Objects.equals(getStatus(), that.getStatus()) &&
                Objects.equals(getPhoneNo(), that.getPhoneNo()) &&
                Objects.equals(getSkype(), that.getSkype()) &&
                Objects.equals(getCountry(), that.getCountry()) &&
                Objects.equals(getCity(), that.getCity()) &&
                Objects.equals(getTimezone(), that.getTimezone()) &&
                Objects.equals(getDefaultPrice(), that.getDefaultPrice()) &&
                Objects.equals(getDefaultDuration(), that.getDefaultDuration());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstName(), getLastName(), getStatus(), getPhoneNo(), getSkype(), getCountry(), getCity(), getTimezone(), getDefaultPrice(), getDefaultDuration());
    }

    @Override
    public String toString() {
        return "StudentResponse{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", status='" + status + '\'' +
                "\n" +
                ", phoneNo='" + phoneNo + '\'' +
                ", skype='" + skype + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", timezone='" + timezone + '\'' +
                ", defaultPrice='" + defaultPrice + '\'' +
                ", defaultDuration='" + defaultDuration + '\'' +
                '}' +
                "\n";
    }
}
