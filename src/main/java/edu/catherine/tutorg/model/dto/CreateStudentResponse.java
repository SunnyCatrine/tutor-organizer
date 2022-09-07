package main.java.edu.catherine.tutorg.model.dto;

import java.util.Objects;

public class CreateStudentResponse {
    private String studentId;
    private String firstName;
    private String lastName;
    private String status;


    public CreateStudentResponse(String studentId, String firstName, String lastName, String status) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.status = status;
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

    public String getStatus() {return status;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CreateStudentResponse)) return false;
        CreateStudentResponse that = (CreateStudentResponse) o;
        return Objects.equals(getStudentId(), that.getStudentId()) &&
                Objects.equals(getFirstName(), that.getFirstName()) &&
                Objects.equals(getLastName(), that.getLastName()) &&
                Objects.equals(getStatus(), that.getStatus());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStudentId(), getFirstName(), getLastName(), getStatus());
    }

    @Override
    public String toString() {
        return "CreateStudentResponse{" +
                "studentId=" + studentId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
