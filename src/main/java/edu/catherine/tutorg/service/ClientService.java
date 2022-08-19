package main.java.edu.catherine.tutorg.service;

import main.java.edu.catherine.tutorg.dao.ClientDao;

public class ClientService {
    private final ClientDao clientDao = ClientDao.getInstance();
    private final static ClientService INSTANCE = new ClientService();

    private ClientService() {
    }

    public static ClientService getInstance() {
        return INSTANCE;
    }
}
