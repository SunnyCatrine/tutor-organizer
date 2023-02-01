package main.java.edu.catherine.tutorg.model.entity.client;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Contact {
    private String phoneNo;
    private String skype;
}
