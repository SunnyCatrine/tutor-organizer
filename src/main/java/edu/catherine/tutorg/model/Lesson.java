package main.java.edu.catherine.tutorg.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Lesson {
    LocalDateTime dateTime;
    LessonStatus status;
    PaymentStatus paymentStatus;
    LessonWork classWork;
    LessonWork homeWork;
    LessonParam currentLessonParam;

    public Lesson(LocalDateTime dateTime, LessonStatus status, PaymentStatus paymentStatus, LessonWork classWork, LessonWork homeWork, LessonParam currentLessonParam) {
        this.dateTime = dateTime;
        this.status = status;
        this.paymentStatus = paymentStatus;
        this.classWork = classWork;
        this.homeWork = homeWork;
        this.currentLessonParam = currentLessonParam;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public LessonStatus getStatus() {
        return status;
    }

    public void setStatus(LessonStatus status) {
        this.status = status;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public LessonWork getClassWork() {
        return classWork;
    }

    public void setClassWork(LessonWork classWork) {
        this.classWork = classWork;
    }

    public LessonWork getHomeWork() {
        return homeWork;
    }

    public void setHomeWork(LessonWork homeWork) {
        this.homeWork = homeWork;
    }

    public LessonParam getCurrentLessonParam() {
        return currentLessonParam;
    }

    public void setCurrentLessonParam(LessonParam currentLessonParam) {
        this.currentLessonParam = currentLessonParam;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lesson)) return false;
        Lesson lesson = (Lesson) o;
        return getDateTime().equals(lesson.getDateTime()) &&
                getStatus().equals(lesson.getStatus()) &&
                getPaymentStatus().equals(lesson.getPaymentStatus()) &&
                Objects.equals(getClassWork(), lesson.getClassWork()) &&
                Objects.equals(getHomeWork(), lesson.getHomeWork()) &&
                getCurrentLessonParam().equals(lesson.getCurrentLessonParam());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDateTime(), getStatus(), getPaymentStatus(), getClassWork(), getHomeWork(), getCurrentLessonParam());
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "dateTime=" + dateTime +
                ", status=" + status +
                ", paymentStatus=" + paymentStatus +
                ", classWork=" + classWork +
                ", homeWork=" + homeWork +
                ", currentLessonParam=" + currentLessonParam +
                '}';
    }
}
