package main.java.edu.catherine.tutorg.model.client.ext;

import main.java.edu.catherine.tutorg.model.client.Client;
import main.java.edu.catherine.tutorg.model.client.Contact;
import main.java.edu.catherine.tutorg.model.client.Location;

import java.util.List;
import java.util.Objects;

public class Agent extends Client {
    List<Student> studentList;

    public Agent(String firstName, String lastName, Contact contact, Location location) {
        super(firstName, lastName, contact, location);
    }

    public List<Student> getStudentList() {
        return studentList;
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
        return getStudentList().equals(agent.getStudentList());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getStudentList());
    }

    @Override
    public String toString() {
        return "Agent{" +
                "studentList=" + studentList +
                '}';
    }
}
