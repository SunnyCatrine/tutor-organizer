package main.java.edu.catherine.tutorg.model;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Map;
import java.util.Objects;

public class Schedule {
    Map<DayOfWeek, LocalTime> schedule;

    public Schedule(Map<DayOfWeek, LocalTime> schedule) {
        this.schedule = schedule;
    }

    public Map<DayOfWeek, LocalTime> getSchedule() {
        return schedule;
    }

    public void setSchedule(Map<DayOfWeek, LocalTime> schedule) {
        this.schedule = schedule;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Schedule)) return false;
        Schedule schedule1 = (Schedule) o;
        return getSchedule().equals(schedule1.getSchedule());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSchedule());
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "schedule=" + schedule +
                '}';
    }
}
