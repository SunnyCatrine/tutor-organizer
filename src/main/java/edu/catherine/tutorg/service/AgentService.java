package main.java.edu.catherine.tutorg.service;

import main.java.edu.catherine.tutorg.dao.AgentDao;
import main.java.edu.catherine.tutorg.mapper.AgentMapper;
import main.java.edu.catherine.tutorg.model.dto.AgentRequest;
import main.java.edu.catherine.tutorg.model.dto.AgentResponse;
import main.java.edu.catherine.tutorg.model.entity.client.impl.Agent;
import main.java.edu.catherine.tutorg.model.entity.client.impl.Student;
import main.java.edu.catherine.tutorg.util.ConnectionManager;

import java.sql.Connection;
import java.sql.SQLException;

public class AgentService {
    private static final AgentService INSTANCE = new AgentService(AgentDao.getInstance());
    private final AgentDao agentDao;

    private AgentService(AgentDao agentDao) {
        this.agentDao = agentDao;
    }


    public static AgentService getInstance() {
        return INSTANCE;
    }

    public AgentResponse create(String studentId, AgentRequest agentRequest) throws SQLException {
        Agent agent = AgentMapper.toCreateEntity(agentRequest);
        try (Connection connection = ConnectionManager.get()) {
            return AgentMapper.toResponse(agentDao.create(connection, studentId, agent));
        }
    }
}
