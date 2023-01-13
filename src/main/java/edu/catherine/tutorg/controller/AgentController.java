package main.java.edu.catherine.tutorg.controller;

import main.java.edu.catherine.tutorg.model.dto.AgentRequest;
import main.java.edu.catherine.tutorg.model.dto.AgentResponse;
import main.java.edu.catherine.tutorg.service.AgentService;

import java.sql.SQLException;
import java.util.List;

public final class AgentController {
    private static final AgentController INSTANCE = new AgentController(AgentService.getInstance());
    private final AgentService agentService;

    private AgentController(AgentService agentService) {
        this.agentService = agentService;
    }

    public AgentResponse create(AgentRequest agentRequest) throws SQLException {
        return agentService.create(agentRequest);
    }

    public List<AgentResponse> findByStudentId(String studentId) throws SQLException {
        return agentService.findByStudentId(studentId);
    }

    public AgentResponse deleteById(String id) throws SQLException {
        return agentService.deleteById(id);
    }

    public static AgentController getInstance() {
        return INSTANCE;
    }
}
