package main.java.edu.catherine.tutorg.model.entity.lesson;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Builder
public class Lesson {
    private LocalDateTime dateTime;
    private LessonStatus status;
    private PaymentStatus paymentStatus;
    private LessonWork classWork;
    private LessonWork homeWork;
    private LessonParam currentLessonParam;
}
