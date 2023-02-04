package main.java.edu.catherine.tutorg.model.entity.client.impl;

import lombok.*;
import main.java.edu.catherine.tutorg.model.entity.client.Client;
import main.java.edu.catherine.tutorg.model.entity.client.Location;

import java.util.List;

@Builder
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
public class Agent extends Client {
    private String phoneNo;
    private List<Student> studentList;

    public Agent(Integer id, String firstName, String lastName, String phoneNo, Location location) {
        super(id, firstName, lastName, location);
        this.phoneNo = phoneNo;
    }

    public Agent(String firstName, String lastName, String phoneNo, Location location) {
        super(firstName, lastName, location);
        this.phoneNo = phoneNo;
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
