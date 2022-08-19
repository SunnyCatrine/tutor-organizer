package main.java.edu.catherine.tutorg.controller;

import main.java.edu.catherine.tutorg.service.ClientService;

public final class ClientController {
    private final ClientService clientService = ClientService.getInstance();
    private static final ClientController INSTANCE = new ClientController();

    private ClientController() {
    }

    public static ClientController getINSTANCE() {
        return INSTANCE;
    }
}
