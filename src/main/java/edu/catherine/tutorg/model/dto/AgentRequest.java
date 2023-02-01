package main.java.edu.catherine.tutorg.model.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class AgentRequest {
    String firstName;
    String lastName;
    String country;
    String city;
    String timezone;
    String phoneNo;
    String studentId;
}
