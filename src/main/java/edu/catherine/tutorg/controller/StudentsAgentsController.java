package main.java.edu.catherine.tutorg.controller;

import main.java.edu.catherine.tutorg.service.StudentsAgentsService;

import java.sql.SQLException;

public final class StudentsAgentsController {
    private static final StudentsAgentsController INSTANCE = new StudentsAgentsController(StudentsAgentsService.getInstance());
    private final StudentsAgentsService studentsAgentsService;

    private StudentsAgentsController(StudentsAgentsService studentsAgentsService) {
        this.studentsAgentsService = studentsAgentsService;
    }

    public Boolean assignAgentToStudent(String studentId, String agentId) throws SQLException {
        return studentsAgentsService.assignAgentToStudent(studentId, agentId);
    }

    public static StudentsAgentsController getINSTANCE() {
        return INSTANCE;
    }
}
