package main.java.edu.catherine.tutorg.model.client;

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

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getSkype() {
        return skype;
    }

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
