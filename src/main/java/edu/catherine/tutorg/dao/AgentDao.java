package main.java.edu.catherine.tutorg.dao;

import main.java.edu.catherine.tutorg.model.entity.client.Location;
import main.java.edu.catherine.tutorg.model.entity.client.impl.Agent;
import main.java.edu.catherine.tutorg.model.entity.client.impl.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static main.java.edu.catherine.tutorg.util.sql.SqlConstants.*;

public class AgentDao {
    private static final AgentDao INSTANCE = new AgentDao(StudentsAgentsDao.getInstance(), StudentDao.getInstance());
    private StudentsAgentsDao studentsAgentsDao;
    private StudentDao studentDao;

    private AgentDao(StudentsAgentsDao studentsAgentsDao, StudentDao studentDao) {
        this.studentsAgentsDao = studentsAgentsDao;
        this.studentDao = studentDao;
    }

    public Agent create(Connection connection, Integer studentId, Agent agent) throws SQLException {
        Integer agentId = null;
        try (PreparedStatement agentCreate = connection.prepareStatement(CREATE_AGENT_SQL, Statement.RETURN_GENERATED_KEYS)) {

            agentCreate.setString(1, agent.getFirstName());
            agentCreate.setString(2, agent.getLastName());
            agentCreate.setString(3, agent.getLocation().getCountry());
            agentCreate.setString(4, agent.getLocation().getCity());
            agentCreate.setString(5, agent.getPhoneNo());
            agentCreate.setString(6, agent.getLocation().getTimezone());

            agentCreate.executeUpdate();
            ResultSet resultSet = agentCreate.getGeneratedKeys();
            if (resultSet.next()) {
                agentId = resultSet.getInt(ID);
                studentsAgentsDao.create(connection, studentId, agentId);
            }
            return  findBy(connection, agentId);
        }
    }

    public List<Agent> findByStudentId(Connection connection, Integer studentId) throws SQLException {
        List<Agent> resultList = new ArrayList<>();
        List<Integer> agentIdList = getAgentIdListByStudentId(connection, studentId);
        for (Integer agentId: agentIdList) {
            Agent agent = findBy(connection, agentId);
            resultList.add(agent);
        }
        return resultList;
    }

    public Agent deleteById(Connection connection, Integer id) throws SQLException {
        Agent resultAgent = findBy(connection, id);
        try (PreparedStatement deleteAgent =connection.prepareStatement(DELETE_AGENT_SQL)) {

            deleteAgent.setInt(1, id);

            if (deleteAgent.executeUpdate() > 0) {
                return resultAgent;
            }
            return null;
        }
    }

    private Agent findBy(Connection connection, Integer agentId) throws SQLException {
        Agent resultAgent = null;
        try (PreparedStatement findAgent = connection.prepareStatement(FIND_AGENT_SQL)) {

            findAgent.setInt(1, agentId);

            findAgent.executeQuery();

            ResultSet resultSet = findAgent.getResultSet();
            if (resultSet.next()) {
                resultAgent = buildAgent(resultSet);
            }
            resultAgent.setStudentList(getStudentListByAgentId(connection, agentId));

            return resultAgent;
        }
    }

    private List<Integer> getAgentIdListByStudentId(Connection connection, Integer studentId) throws SQLException {
        return studentsAgentsDao.findAgentIdListByStudentId(connection, studentId);
    }

    private List<Student> getStudentListByAgentId(Connection connection, Integer agentId) throws SQLException {
        List<Integer> studentIdList = studentsAgentsDao.findStudentIdListByAgentId(connection, agentId);
        return getStudentListByStudentIdList(connection, studentIdList);
    }

    private List<Student> getStudentListByStudentIdList(Connection connection, List<Integer> studentIdList) throws SQLException {
        List<Student> studentList = new ArrayList<>();
        for (Integer studentId : studentIdList) {
            studentList.add(studentDao.findBy(connection, studentId));
        }
        return studentList;
    }

    private Agent buildAgent(ResultSet resultSet) throws SQLException {
        Location location = new Location(
                resultSet.getString(COUNTRY),
                resultSet.getString(CITY),
                resultSet.getString(TIMEZONE)
        );
        return new Agent(
                resultSet.getInt(ID),
                resultSet.getString(FIRST_NAME),
                resultSet.getString(LAST_NAME),
                resultSet.getString(PHONE_NO),
                location);
    }


    public static AgentDao getInstance() {
        return INSTANCE;
    }
}
