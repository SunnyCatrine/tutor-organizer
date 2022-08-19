package main.java.edu.catherine.tutorg.dao;

public final class ClientDao {
    private static final ClientDao INSTANCE = new ClientDao();

    private ClientDao() {
    }

    public static ClientDao getInstance() {
        return INSTANCE;
    }
}
