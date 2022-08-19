package main.java.edu.catherine.tutorg.model;

import java.util.Objects;

public class LessonWork {
    String topic;
    TopicProgress topicProgress;

    public LessonWork(String topic, TopicProgress topicProgress) {
        this.topic = topic;
        this.topicProgress = topicProgress;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public TopicProgress getTopicProgress() {
        return topicProgress;
    }

    public void setTopicProgress(TopicProgress topicProgress) {
        this.topicProgress = topicProgress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LessonWork)) return false;
        LessonWork that = (LessonWork) o;
        return Objects.equals(getTopic(), that.getTopic()) &&
                Objects.equals(getTopicProgress(), that.getTopicProgress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTopic(), getTopicProgress());
    }

    @Override
    public String toString() {
        return "LessonWork{" +
                "topic='" + topic + '\'' +
                ", progress=" + topicProgress +
                '}';
    }
}
