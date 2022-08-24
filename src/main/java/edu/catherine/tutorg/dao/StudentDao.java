package main.java.edu.catherine.tutorg.dao;

public class StudentDao {
    private static final StudentDao INSTANCE = new StudentDao();

    private StudentDao() {
    }

    public static StudentDao getINSTANCE() {
        return INSTANCE;
    }

}
