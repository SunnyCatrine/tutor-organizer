package main.java.edu.catherine.tutorg.model.entity.client;

import jakarta.xml.bind.annotation.XmlElement;

import java.util.Objects;

public class Location {
    private String country;
    private String city;
    private String timezone;

    public Location(String country, String city, String timezone) {
        this.country = country;
        this.city = city;
        this.timezone = timezone;
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

    @XmlElement
    public void setCountry(String country) {
        this.country = country;
    }
    @XmlElement
    public void setCity(String city) {
        this.city = city;
    }
    @XmlElement
    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Location)) return false;
        Location location = (Location) o;
        return getCountry().equals(location.getCountry()) &&
                Objects.equals(getCity(), location.getCity()) &&
                Objects.equals(getTimezone(), location.getTimezone());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCountry(), getCity(), getTimezone());
    }
    @Override
    public String toString() {
        return "Location{" +
                "country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", timezone='" + timezone + '\'' +
                '}';
    }
}
