package main.java.edu.catherine.tutorg.model.entity.client;

import lombok.AllArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
public enum StudentStatus {
    ACTIVE("ACTIVE"),
    ARCHIVED("ARCHIVED");

    private String status;

    public String getStatusValue() {
        return status;
    }
}
