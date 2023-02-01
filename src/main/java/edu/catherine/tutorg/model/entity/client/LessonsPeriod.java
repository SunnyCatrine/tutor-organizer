package main.java.edu.catherine.tutorg.model.entity.client;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
public class LessonsPeriod {
    private LocalDate firstLessonDate;
    private LocalDate lastLessonDate;
}

