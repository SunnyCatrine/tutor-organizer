package main.java.edu.catherine.tutorg.model.entity.lesson;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class LessonParam {
    private Integer price;
    private Integer duration;
}
