package main.java.edu.catherine.tutorg.model.dto;

import java.util.List;
import java.util.Objects;

public final class AgentResponse {
    private final String id;
    private final String firstName;
    private final String lastName;
    private final String country;
    private final String city;
    private final String timezone;
    private final String phoneNo;
    private final String skype;
    private final List<String> studentIdList;

    public AgentResponse(
            String id,
            String firstName,
            String lastName,
            String country,
            String city,
            String timezone,
            String phoneNo,
            String skype,
            List<String> studentIdList) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.city = city;
        this.timezone = timezone;
        this.phoneNo = phoneNo;
        this.skype = skype;
        this.studentIdList = studentIdList;
    }

    public static AgentResponseBuilder builder() { return new AgentResponseBuilder();}

    public static class AgentResponseBuilder {
        private String id;
        private String firstName;
        private String lastName;
        private String country;
        private String city;
        private String timezone;
        private String phoneNo;
        private String skype;
        private List<String> studentIdList;

        public AgentResponseBuilder id(String id) {
            this.id = id;
            return this;
        }

        public AgentResponseBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public AgentResponseBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public AgentResponseBuilder country(String country) {
            this.country = country;
            return this;
        }

        public AgentResponseBuilder city(String city) {
            this.city = city;
            return this;
        }

        public AgentResponseBuilder timezone(String timezone) {
            this.timezone = timezone;
            return this;
        }

        public AgentResponseBuilder phoneNo(String phoneNo) {
            this.phoneNo = phoneNo;
            return this;
        }

        public AgentResponseBuilder skype(String skype) {
            this.skype = skype;
            return this;
        }

        public AgentResponseBuilder studentIdList(List<String> studentIdList) {
            this.studentIdList = studentIdList;
            return this;
        }

        public AgentResponse build() {
            return new AgentResponse(
                    id,
                    firstName,
                    lastName,
                    country,
                    city,
                    timezone,
                    phoneNo,
                    skype,
                    studentIdList
            );
        }
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

    public List<String> getStudentIdList() {
        return studentIdList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AgentResponse)) return false;
        AgentResponse that = (AgentResponse) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getFirstName(), that.getFirstName()) &&
                Objects.equals(getLastName(), that.getLastName()) &&
                Objects.equals(getCountry(), that.getCountry()) &&
                Objects.equals(getCity(), that.getCity()) &&
                Objects.equals(getTimezone(), that.getTimezone()) &&
                Objects.equals(getPhoneNo(), that.getPhoneNo()) &&
                Objects.equals(getSkype(), that.getSkype()) &&
                Objects.equals(getStudentIdList(), that.getStudentIdList());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstName(), getLastName(), getCountry(), getCity(), getTimezone(), getPhoneNo(), getSkype(), getStudentIdList());
    }

    @Override
    public String toString() {
        return "AgentResponse{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", timezone='" + timezone + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", skype='" + skype + '\'' +
                ", studentIdList=" + studentIdList +
                '}';
    }
}
