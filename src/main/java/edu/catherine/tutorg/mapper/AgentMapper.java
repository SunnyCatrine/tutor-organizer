package main.java.edu.catherine.tutorg.mapper;

import main.java.edu.catherine.tutorg.model.dto.AgentRequest;
import main.java.edu.catherine.tutorg.model.dto.AgentResponse;
import main.java.edu.catherine.tutorg.model.entity.client.Contact;
import main.java.edu.catherine.tutorg.model.entity.client.Location;
import main.java.edu.catherine.tutorg.model.entity.client.impl.Agent;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AgentMapper {

    public static Agent toCreateEntity(AgentRequest agentRequest) {
        Location location = new Location(
                agentRequest.getCountry(),
                agentRequest.getCity(),
                agentRequest.getTimezone()
        );

        return new Agent(
                agentRequest.getFirstName(),
                agentRequest.getLastName(),
                agentRequest.getPhoneNo(),
                location);
    }
    
    public static AgentResponse toResponse(Agent agent) {
        List<String> studentIdList = agent.getStudentList().stream()
                .map(student -> student.getClientId().toString())
                .collect(Collectors.toList());
        return AgentResponse.builder()
                .id(agent.getClientId().toString())
                .firstName(agent.getFirstName())
                .lastName(agent.getLastName())
                .country(agent.getLocation().getCountry())
                .city(agent.getLocation().getCity())
                .timezone(agent.getLocation().getTimezone())
                .phoneNo(agent.getPhoneNo())
                .studentIdList(studentIdList)
                .build();
    }
}
