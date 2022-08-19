package main.java.edu.catherine.tutorg.dao;

import main.java.edu.catherine.tutorg.model.client.ext.Student;

import java.util.Arrays;
import java.util.List;

public final class ClientDao {
    private static final ClientDao INSTANCE = new ClientDao();

    private ClientDao() {
    }

    public static ClientDao getInstance() {
        return INSTANCE;
    }

    public Student createStudent(Student studentRequest) {
        return null;
    }

    public List<Student> findAllStudents() {
        return null;
    }
}
