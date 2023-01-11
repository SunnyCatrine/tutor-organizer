package main.java.edu.catherine.tutorg.model.entity.client;

import jakarta.xml.bind.annotation.XmlElement;

import java.util.Objects;

public class Contact {
    private String phoneNo;
    private String skype;

    public Contact(String phoneNo, String skype) {
        this.phoneNo = phoneNo;
        this.skype = skype;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public String getSkype() {
        return skype;
    }

    @XmlElement
    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
    @XmlElement
    public void setSkype(String skype) {
        this.skype = skype;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contact)) return false;
        Contact contact = (Contact) o;
        return Objects.equals(getPhoneNo(), contact.getPhoneNo()) &&
                Objects.equals(getSkype(), contact.getSkype());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPhoneNo(), getSkype());
    }

    @Override
    public String toString() {
        return "Contact{" +
                "phoneNo='" + phoneNo + '\'' +
                ", skype='" + skype + '\'' +
                '}';
    }
}
