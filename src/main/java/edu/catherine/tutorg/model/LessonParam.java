package main.java.edu.catherine.tutorg.model;

import java.util.Objects;

public class LessonParam {
    Integer price;
    Double duration;

    public LessonParam(Integer price, Double duration) {
        this.price = price;
        this.duration = duration;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Double getDuration() {
        return duration;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LessonParam)) return false;
        LessonParam that = (LessonParam) o;
        return getPrice().equals(that.getPrice()) &&
                getDuration().equals(that.getDuration());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPrice(), getDuration());
    }

    @Override
    public String toString() {
        return "LessonParam{" +
                "price=" + price +
                ", duration=" + duration +
                '}';
    }
}
