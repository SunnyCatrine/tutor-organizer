package main.java.edu.catherine.tutorg.dao;

import main.java.edu.catherine.tutorg.model.entity.client.Location;
import main.java.edu.catherine.tutorg.model.entity.client.impl.Agent;

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
            agentCreate.setString(5, agent.getPhoneNo());
            agentCreate.setString(6, agent.getLocation().getTimezone());

            agentCreate.executeUpdate();
            ResultSet resultSet = agentCreate.getResultSet();
            if (resultSet.next()) {
                agentId = resultSet.getInt(ID);
                addNoteToStudentsAgentsTable(connection, studentId, agentId);
            }
            return findBy(connection, agentId);
        }
    }

    public Agent findByStudentId(Connection connection, Integer id) throws SQLException {
        Integer agentId = findAgentId(connection, id);
        return findBy(connection, agentId);
    }

    public Agent deleteByStudentId(Connection connection, Integer id) throws SQLException {
        Integer agentId = findAgentId(connection, id);
        Agent resultAgent = findBy(connection, agentId);
        try (PreparedStatement deleteAgent =connection.prepareStatement(DELETE_AGENT_SQL)) {

            deleteAgent.setInt(1,agentId);

            if (deleteAgent.executeUpdate() > 0) {
                return resultAgent;
            }
            return null;
        }
    }

    private Integer findAgentId(Connection connection, Integer studentId) throws SQLException {
        Integer agentId = null;
        try (PreparedStatement findAgentId = connection.prepareStatement(FIND_AGENT_ID_SQL)) {

            findAgentId.setInt(1, studentId);

            findAgentId.executeQuery();

            ResultSet resultSet = findAgentId.getResultSet();
            if (resultSet.next()) {
                agentId = resultSet.getInt(AGENT_ID);
            }
            return agentId;
        }
    }

    private Agent findBy(Connection connection, Integer agentId) throws SQLException {
        Agent resultAgent = null;
        try (PreparedStatement findAgent = connection.prepareStatement(FIND_AGENT_SQL)) {

            findAgent.setInt(1,agentId);

            findAgent.executeQuery();

            ResultSet resultSet = findAgent.getResultSet();
            if (resultSet.next()) {
                resultAgent = buildAgent(resultSet);
            }
            return resultAgent;
        }
    }

    private Agent buildAgent(ResultSet resultSet) throws SQLException {
        Location location = new Location(
                resultSet.getString(COUNTRY),
                resultSet.getString(CITY),
                resultSet.getString(TIMEZONE)
        );
        return new Agent(
                resultSet.getInt(AGENT_ID),
                resultSet.getString(FIRST_NAME),
                resultSet.getString(LAST_NAME),
                resultSet.getString(PHONE_NO),
                location);
    }

    private void addNoteToStudentsAgentsTable(Connection connection, String studentId, Integer agentId) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(ADD_NOTE_TO_STUDENTS_AGENTS_TABLE_SQL)) {

            preparedStatement.setInt(1, Integer.parseInt(studentId));
            preparedStatement.setInt(2, agentId);

            preparedStatement.executeUpdate();
        }
    }
}
