package main.java.edu.catherine.tutorg.model.entity.client;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Location {
    private String country;
    private String city;
    private String timezone;
}
