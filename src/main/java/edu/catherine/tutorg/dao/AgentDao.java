package main.java.edu.catherine.tutorg.dao;

import main.java.edu.catherine.tutorg.model.entity.client.impl.Agent;
import main.java.edu.catherine.tutorg.util.ConnectionManager;
import main.java.edu.catherine.tutorg.util.sql.SqlConstants;

import java.sql.*;

import static main.java.edu.catherine.tutorg.util.sql.SqlConstants.*;

public class AgentDao {
    private static final AgentDao INSTANCE = new AgentDao();


    public static AgentDao getInstance() {
        return INSTANCE;
    }

    public Agent create(Connection connection, String studentId, Agent agent) throws SQLException {
        Integer agentId = null;
        try (PreparedStatement agentCreate = connection.prepareStatement(CREATE_AGENT_SQL, Statement.RETURN_GENERATED_KEYS)) {

            agentCreate.setString(1, agent.getFirstName());
            agentCreate.setString(2, agent.getLastName());
            agentCreate.setString(3, agent.getLocation().getCountry());
            agentCreate.setString(4, agent.getLocation().getCity());
            agentCreate.setString(5, agent.getContact().getPhoneNo());
            agentCreate.setString(6, agent.getContact().getSkype());

            agentCreate.executeUpdate();
            ResultSet resultSet = agentCreate.getResultSet();
            if (resultSet.next()) {
                agentId = resultSet.getInt(ID);
                addNoteToStudentsAgentsTable(connection, studentId, agentId);
            }
            return findBy(connection, agentId);
        }
    }

    public Agent findBy(Connection connection, Integer agentId) {
    }

    private void addNoteToStudentsAgentsTable(Connection connection, String studentId, Integer agentId) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(ADD_NOTE_TO_STUDENTS_AGENTS_TABLE_SQL)) {

            preparedStatement.setInt(1, Integer.parseInt(studentId));
            preparedStatement.setInt(2, agentId);

            preparedStatement.executeUpdate();
        }
    }
}
