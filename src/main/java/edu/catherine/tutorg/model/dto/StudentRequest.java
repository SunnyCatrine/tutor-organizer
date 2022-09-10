package main.java.edu.catherine.tutorg.model.dto;

import java.util.Objects;

public final class StudentRequest {
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

    public StudentRequest() {
    }


    public StudentRequest(String firstName,
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

    public static StudentRequestBuilder builder() {
        return new StudentRequestBuilder();
    }

    public final static class StudentRequestBuilder {
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

        public final StudentRequestBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public final StudentRequestBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public final StudentRequestBuilder phoneNo(String phoneNo) {
            this.phoneNo = phoneNo;
            return this;
        }

        public final StudentRequestBuilder skype(String skype) {
            this.skype = skype;
            return this;
        }

        public final StudentRequestBuilder country(String country) {
            this.country = country;
            return this;
        }

        public final StudentRequestBuilder city(String city) {
            this.city = city;
            return this;
        }

        public final StudentRequestBuilder timezone(String timezone) {
            this.timezone = timezone;
            return this;
        }

        public final StudentRequestBuilder defaultPrice(String price) {
            this.defaultPrice = price;
            return this;
        }

        public final StudentRequestBuilder defaultDuration(String duration) {
            this.defaultDurationInMinutes = duration;
            return this;
        }

        public final StudentRequestBuilder status(String status) {
            this.studentStatus = status;
            return this;
        }

        public final StudentRequest build() {
            return new StudentRequest(
                    firstName,
                    lastName,
                    phoneNo,
                    skype,
                    country,
                    city,
                    timezone,
                    defaultPrice,
                    defaultDurationInMinutes,
                    studentStatus
            );
        }
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
        if (!(o instanceof StudentRequest)) return false;
        StudentRequest that = (StudentRequest) o;
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
        return "StudentRequest{" +
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
