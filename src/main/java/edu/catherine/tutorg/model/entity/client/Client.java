package main.java.edu.catherine.tutorg.model.entity.client;

import java.util.Objects;

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

    public Client(Integer clientId, String firstName, String lastName, Location location) {
        this.clientId = clientId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.location = location;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Location getLocation() {
        return location;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client)) return false;
        Client client = (Client) o;
        return getFirstName().equals(client.getFirstName()) &&
                Objects.equals(getLastName(), client.getLastName()) &&
                Objects.equals(getLocation(), client.getLocation());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getLastName(), getLocation());
    }

    @Override
    public String toString() {
        return "clientId=" + clientId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", location=" + location;
    }
}
