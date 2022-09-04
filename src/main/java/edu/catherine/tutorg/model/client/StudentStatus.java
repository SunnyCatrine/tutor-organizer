package main.java.edu.catherine.tutorg.model.client;

public enum StudentStatus {
    // DONE: 30.08.2022 you should choose one style of const
    ACTIVE("ACTIVE"),
    ARCHIVED("ARCHIVED");

    private String status;

    StudentStatus(String status) {
        this.status = status;
    }

    public String getStatusValue() {
        return status;
    }

    @Override
    public String toString() {
        return "StudentStatus{" +
                "status='" + status + '\'' +
                '}';
    }
}
