package main.java.edu.catherine.tutorg.model.entity.client;

public enum StudentStatus {
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
