package main.java.edu.catherine.tutorg.controller;

import main.java.edu.catherine.tutorg.model.dto.AgentRequest;
import main.java.edu.catherine.tutorg.model.dto.AgentResponse;
import main.java.edu.catherine.tutorg.service.AgentService;

import java.sql.SQLException;

public final class AgentController {
    private static final AgentController INSTANCE = new AgentController(AgentService.getInstance());
    private final AgentService agentService;

    private AgentController(AgentService agentService) {
        this.agentService = agentService;
    }

    public AgentResponse create(String studentId, AgentRequest agentRequest) throws SQLException {
        return agentService.create(studentId, agentRequest);
    }
    


    public static AgentController getInstance() {
        return INSTANCE;
    }
}
