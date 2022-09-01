package main.java.edu.catherine.tutorg.model.dto;

import java.util.Objects;

public class CreateStudentResponseDto {
    private Integer studentId;
    private String firstName;
    private String lastName;

    public CreateStudentResponseDto(Integer studentId, String firstName, String lastName) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CreateStudentResponseDto)) return false;
        CreateStudentResponseDto that = (CreateStudentResponseDto) o;
        return getStudentId().equals(that.getStudentId()) &&
                getFirstName().equals(that.getFirstName()) &&
                getLastName().equals(that.getLastName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStudentId(), getFirstName(), getLastName());
    }

    @Override
    public String toString() {
        return "CreateStudentResponseDto{" +
                "studentId=" + studentId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
