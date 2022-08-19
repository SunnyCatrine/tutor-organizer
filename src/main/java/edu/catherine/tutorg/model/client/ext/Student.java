package main.java.edu.catherine.tutorg.model.client.ext;

import main.java.edu.catherine.tutorg.model.Lesson;
import main.java.edu.catherine.tutorg.model.LessonParam;
import main.java.edu.catherine.tutorg.model.Schedule;
import main.java.edu.catherine.tutorg.model.SubjectBlock;
import main.java.edu.catherine.tutorg.model.client.Client;
import main.java.edu.catherine.tutorg.model.client.Contact;
import main.java.edu.catherine.tutorg.model.client.Location;

import java.util.List;

public class Student extends Client {
    List<SubjectBlock> subjects;
    Agent agent;
    LessonParam defaultLessonParam;
    Schedule schedule;
    List<Lesson> lessonList;
    StudentStatus studentStatus;

    public Student(String firstName, String lastName, Contact contact, Location location) {
        super(firstName, lastName, contact, location);
    }
}
