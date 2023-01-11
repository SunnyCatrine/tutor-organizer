package main.java.edu.catherine.tutorg.model.entity.client;

import jakarta.xml.bind.annotation.XmlElement;

import java.time.LocalDate;
import java.util.Objects;

public class LessonsPeriod {
    private LocalDate firstLessonDate;
    private LocalDate lastLessonDate;

    public LessonsPeriod(LocalDate firstLessonDate, LocalDate lastLessonDate) {
        this.firstLessonDate = firstLessonDate;
        this.lastLessonDate = lastLessonDate;
    }

    public LocalDate getFirstLessonDate() {
        return firstLessonDate;
    }
    @XmlElement
    public void setFirstLessonDate(LocalDate firstLessonDate) {
        this.firstLessonDate = firstLessonDate;
    }

    public LocalDate getLastLessonDate() {
        return lastLessonDate;
    }
    @XmlElement()
    public void setLastLessonDate(LocalDate lastLessonDate) {
        this.lastLessonDate = lastLessonDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LessonsPeriod)) return false;
        LessonsPeriod that = (LessonsPeriod) o;
        return getFirstLessonDate().equals(that.getFirstLessonDate()) &&
                Objects.equals(getLastLessonDate(), that.getLastLessonDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstLessonDate(), getLastLessonDate());
    }

    @Override
    public String toString() {
        return "LessonsPeriod{" +
                "firstLessonDate=" + firstLessonDate +
                ", lastLessonDate=" + lastLessonDate +
                '}';
    }
}

