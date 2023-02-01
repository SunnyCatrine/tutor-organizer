package main.java.edu.catherine.tutorg.model.entity.client;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public abstract class Client {
    private Integer clientId;
    private String firstName;
    private String lastName;
    private Location location;

    public Client(Integer clientId, String firstName, String lastName) {
        this.clientId = clientId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Client(String firstName, String lastName, Location location) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.location = location;
    }
}
