package main.java.edu.catherine.tutorg.model.client;

public enum StudentStatus {
    ACTIVE("ACTIVE"),
    ARCHIVED("Archived");

    private String status;

    StudentStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "StudentStatus{" +
                "status='" + status + '\'' +
                '}';
    }
}
