package main.java.edu.catherine.tutorg.model.dto;

import java.util.Objects;

public final class AgentRequest {
    private final String studentId;
    private final String firstName;
    private final String lastName;
    private final String country;
    private final String city;
    private final String timezone;
    private final String phoneNo;
    private final String skype;

    public AgentRequest(
            String studentId,
            String firstName,
            String lastName,
            String country,
            String city,
            String timezone,
            String phoneNo,
            String skype) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.city = city;
        this.timezone = timezone;
        this.phoneNo = phoneNo;
        this.skype = skype;
    }

    public static AgentRequestBuilder builder() {return new AgentRequestBuilder();}

    private static class AgentRequestBuilder {
        private String studentId;
        private String firstName;
        private String lastName;
        private String country;
        private String city;
        private String timezone;
        private String phoneNo;
        private String skype;

        public AgentRequestBuilder studentId(String studentId) {
            this.studentId = studentId;
            return this;
        }

        public AgentRequestBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public AgentRequestBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public AgentRequestBuilder country(String country) {
            this.country = country;
            return this;
        }

        public AgentRequestBuilder city(String city) {
            this.city = city;
            return this;
        }

        public AgentRequestBuilder timezone(String country) {
            this.country = country;
            return this;
        }

        public AgentRequestBuilder phoneNo(String phoneNo) {
            this.phoneNo = phoneNo;
            return this;
        }

        public AgentRequestBuilder skype(String skype) {
            this.skype = skype;
            return this;
        }

        public AgentRequest build() {
            return new AgentRequest(
                    studentId,
                    firstName,
                    lastName,
                    country,
                    city,
                    timezone,
                    phoneNo,
                    skype
            );
        }
    }

    public String getStudentId() {
        return studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
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

    public String getPhoneNo() {
        return phoneNo;
    }

    public String getSkype() {
        return skype;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AgentRequest)) return false;
        AgentRequest that = (AgentRequest) o;
        return Objects.equals(getStudentId(), that.getStudentId()) &&
                Objects.equals(getFirstName(), that.getFirstName()) &&
                Objects.equals(getLastName(), that.getLastName()) &&
                Objects.equals(getCountry(), that.getCountry()) &&
                Objects.equals(getCity(), that.getCity()) &&
                Objects.equals(getTimezone(), that.getTimezone()) &&
                Objects.equals(getPhoneNo(), that.getPhoneNo()) &&
                Objects.equals(getSkype(), that.getSkype());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStudentId(), getFirstName(), getLastName(), getCountry(), getCity(), getTimezone(), getPhoneNo(), getSkype());
    }

    @Override
    public String toString() {
        return "AgentRequest{" +
                "studentId='" + studentId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", timezone='" + timezone + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", skype='" + skype + '\'' +
                '}';
    }
}
