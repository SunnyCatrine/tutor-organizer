package main.java.edu.catherine.tutorg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static main.java.edu.catherine.tutorg.util.sql.SqlConstants.*;


public final class StudentsAgentsDao {
    private static final StudentsAgentsDao INSTANCE = new StudentsAgentsDao();

    private StudentsAgentsDao() {
    }

    public Boolean create(Connection connection, Integer studentId, Integer agentId) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(ADD_NOTE_TO_STUDENTS_AGENTS_TABLE_SQL)) {

            preparedStatement.setInt(1, studentId);
            preparedStatement.setInt(2, agentId);

            return preparedStatement.executeUpdate() > 0;
        }
    }

    public List<Integer> findAgentIdListByStudentId(Connection connection, Integer requestStudentId) throws SQLException {
        List<Integer> resultList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(FIND_AGENT_ID_LIST_BY_STUDENT_ID)) {

            preparedStatement.setInt(1,requestStudentId);

            preparedStatement.executeQuery();
            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                resultList.add(resultSet.getInt(AGENT_ID));
            }
            return resultList;
        }
    }

    public List<Integer> findStudentIdListByAgentId(Connection connection, Integer agentId) throws SQLException {
        List<Integer> resultList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(FIND_STUDENT_ID_LIST_BY_AGENT_ID)) {

            preparedStatement.setInt(1,agentId);

            preparedStatement.executeQuery();
            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                resultList.add(resultSet.getInt(STUDENT_ID));
            }
            return resultList;
        }
    }

    public static StudentsAgentsDao getInstance() {
        return INSTANCE;
    }
}
