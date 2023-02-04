package main.java.edu.catherine.tutorg.model.entity.lesson;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Data
@AllArgsConstructor
@Builder
public class LessonWork {
    private String topic;
    private TopicProgress topicProgress;
}
