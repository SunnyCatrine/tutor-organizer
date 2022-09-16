package main.java.edu.catherine.tutorg.service;

import main.java.edu.catherine.tutorg.dao.AgentDao;
import main.java.edu.catherine.tutorg.mapper.AgentMapper;
import main.java.edu.catherine.tutorg.model.dto.AgentRequest;
import main.java.edu.catherine.tutorg.model.dto.AgentResponse;
import main.java.edu.catherine.tutorg.model.entity.client.impl.Agent;
import main.java.edu.catherine.tutorg.util.ConnectionManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;


public class AgentService {
    private static final AgentService INSTANCE = new AgentService(AgentDao.getInstance());
    private final AgentDao agentDao;

    private AgentService(AgentDao agentDao) {
        this.agentDao = agentDao;
    }


    public static AgentService getInstance() {
        return INSTANCE;
    }

    public AgentResponse create(AgentRequest agentRequest) throws SQLException {
        Agent agent = AgentMapper.toEntityForCreate(agentRequest);
        Integer studentId = Integer.parseInt(agentRequest.getStudentId());
        try (Connection connection = ConnectionManager.get()) {
            return AgentMapper.toResponse(agentDao.create(connection, studentId, agent));
        }
    }

    public List<AgentResponse> findByStudentId(String studentId) throws SQLException {
        Integer id = Integer.parseInt(studentId);
        try (Connection connection = ConnectionManager.get()) {
            return agentDao.findByStudentId(connection, id)
                    .stream()
                    .map(AgentMapper::toResponse)
                    .collect(Collectors.toList());
        }
    }

    public AgentResponse deleteById(String id) throws SQLException {
        Integer int_id = Integer.parseInt(id);
        try (Connection connection = ConnectionManager.get()) {
            return AgentMapper.toResponse(agentDao.deleteById(connection, int_id));
        }
    }
}
