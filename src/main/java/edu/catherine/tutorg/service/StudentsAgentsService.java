package main.java.edu.catherine.tutorg.service;

import main.java.edu.catherine.tutorg.dao.StudentsAgentsDao;
import main.java.edu.catherine.tutorg.util.ConnectionManager;

import java.sql.Connection;
import java.sql.SQLException;

public final class StudentsAgentsService {
    private static final StudentsAgentsService INSTANCE = new StudentsAgentsService(StudentsAgentsDao.getInstance());
    private final StudentsAgentsDao studentsAgentsDao;

    private StudentsAgentsService(StudentsAgentsDao studentsAgentsDao) {
        this.studentsAgentsDao = studentsAgentsDao;
    }

    public Boolean assignAgentToStudent(String studentId, String agentId) throws SQLException {
        Integer intStudentId = Integer.parseInt(studentId);
        Integer intAgentId = Integer.parseInt(agentId);
        try (Connection connection = ConnectionManager.get()) {
            return studentsAgentsDao.create(connection, intStudentId, intAgentId);
        }
    }

    public static StudentsAgentsService getInstance() {
        return INSTANCE;
    }
}
