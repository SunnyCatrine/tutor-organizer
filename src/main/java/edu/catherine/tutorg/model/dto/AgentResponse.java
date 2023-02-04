package main.java.edu.catherine.tutorg.model.dto;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class AgentResponse {
    String id;
    String firstName;
    String lastName;
    String country;
    String city;
    String timezone;
    String phoneNo;
    List<String> studentIdList;
}
