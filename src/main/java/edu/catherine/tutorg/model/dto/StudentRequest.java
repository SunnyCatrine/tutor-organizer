package main.java.edu.catherine.tutorg.model.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class StudentRequest {
    String firstName;
    String lastName;
    String phoneNo;
    String skype;
    String country;
    String city;
    String timezone;
    String defaultPrice;
    String defaultDurationInMinutes;
    String studentStatus;
}
