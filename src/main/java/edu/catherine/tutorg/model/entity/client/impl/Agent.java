package main.java.edu.catherine.tutorg.model.entity.client.impl;

import main.java.edu.catherine.tutorg.model.entity.client.Client;
import main.java.edu.catherine.tutorg.model.entity.client.Contact;
import main.java.edu.catherine.tutorg.model.entity.client.Location;

import java.util.List;
import java.util.Objects;

public class Agent extends Client {
    String phoneNo;
    List<Student> studentList;

    public Agent(Integer id, String firstName, String lastName, String phoneNo, Location location) {
        super(id, firstName, lastName, location);
        this.phoneNo = phoneNo;
    }

    public Agent(String firstName, String lastName, String phoneNo, Location location) {
        super(firstName, lastName, location);
        this.phoneNo = phoneNo;
    }

    public Agent(Integer clientId, String firstName, String lastName, Location location, String phoneNo, List<Student> studentList) {
        super(clientId, firstName, lastName, location);
        this.phoneNo = phoneNo;
        this.studentList = studentList;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Agent)) return false;
        if (!super.equals(o)) return false;
        Agent agent = (Agent) o;
        return Objects.equals(getPhoneNo(), agent.getPhoneNo()) &&
                Objects.equals(getStudentList(), agent.getStudentList());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getPhoneNo(), getStudentList());
    }

    @Override
    public String toString() {
        return "Agent{"
                + super.toString() 
                + "phoneNo='" + phoneNo
                + "studentList=" + studentList
                + '}';
    }
}
