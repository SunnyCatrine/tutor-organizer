package main.java.edu.catherine.tutorg.controller;

import lombok.SneakyThrows;
import main.java.edu.catherine.tutorg.model.dto.AgentRequest;
import main.java.edu.catherine.tutorg.model.dto.AgentResponse;
import main.java.edu.catherine.tutorg.service.AgentService;

import java.util.List;

public final class AgentController {
    private static final AgentController INSTANCE = new AgentController(AgentService.getInstance());
    private final AgentService agentService;

    private AgentController(AgentService agentService) {
        this.agentService = agentService;
    }

    @SneakyThrows
    public AgentResponse create(AgentRequest agentRequest) {
        return agentService.create(agentRequest);
    }

    @SneakyThrows
    public List<AgentResponse> findByStudentId(String studentId) {
        return agentService.findByStudentId(studentId);
    }

    @SneakyThrows
    public AgentResponse deleteById(String id) {
        return agentService.deleteById(id);
    }

    public static AgentController getInstance() {
        return INSTANCE;
    }
}
