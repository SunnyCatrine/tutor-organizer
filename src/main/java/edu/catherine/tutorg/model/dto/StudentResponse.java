package main.java.edu.catherine.tutorg.model.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class StudentResponse {
    String id;
    String firstName;
    String lastName;
    String status;
    String phoneNo;
    String skype;
    String country;
    String city;
    String timezone;
    String defaultPrice;
    String defaultDuration;
}
