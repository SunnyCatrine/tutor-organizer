package main.java.edu.catherine.tutorg;

import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import main.java.edu.catherine.tutorg.controller.AgentController;
import main.java.edu.catherine.tutorg.controller.StudentController;
import main.java.edu.catherine.tutorg.model.dto.AgentRequest;
import main.java.edu.catherine.tutorg.model.dto.AgentResponse;
import main.java.edu.catherine.tutorg.model.entity.client.Contact;
import main.java.edu.catherine.tutorg.model.entity.client.LessonsPeriod;
import main.java.edu.catherine.tutorg.model.entity.client.Location;
import main.java.edu.catherine.tutorg.model.entity.client.StudentStatus;
import main.java.edu.catherine.tutorg.model.entity.client.impl.Agent;
import main.java.edu.catherine.tutorg.model.entity.lesson.LessonParam;
import main.java.edu.catherine.tutorg.model.xml.StudentXml;
import org.glassfish.jaxb.runtime.v2.runtime.JAXBContextImpl;

import java.nio.file.Path;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TutorgLauncher {

    public static void main(String[] args) throws JAXBException {
        JAXBContextImpl jaxbContext = new JAXBContextImpl.JAXBContextBuilder()
                .setClasses(new Class[] {
                        StudentXml.class,
                        Location.class,
                        Contact.class,
                        LessonParam.class,
                        LessonsPeriod.class,
                        StudentStatus.class,
                        LocalDate.class
//                        Agent.class
                })
                .build();


//        3
        Marshaller marshaller = jaxbContext.createMarshaller();
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

//        5

//        StudentXml studentFromFile = (StudentXml) unmarshaller.unmarshal(
//                Path.of("full.xml").toFile());
//
//        System.out.println(studentFromFile);


        Agent agent1 = new Agent(1,"Fiona","Shrekova","+0987654");
        Agent agent2 = new Agent(2,"Ishak","Ishakov","+0123123");
        List<Agent> agents = new ArrayList<>();
        agents.add(agent1);
        agents.add(agent2);

        marshaller.marshal(new StudentXml(
                44,
                "Shrek",
                "Shrekov",
                StudentStatus.valueOf("ACTIVE"),
                new Location("3/9 kingdom", "bog", "+15"),
                new Contact("+00000", "ShrekCheburek"),
                new LessonParam(2000, 30),
                new LessonsPeriod(LocalDate.of(2022,10,16), LocalDate.of(2023,5,30))
                ), Path.of("student.xml").toFile());


//        StudentController studentController = StudentController.getINSTANCE();
//        AgentController agentController = AgentController.getInstance();

//        checkAgentController(agentController);
//        checkStudentController(studentController);

    }


    private static void checkAgentController(AgentController agentController) throws SQLException {
        System.out.println("ADD NEW AGENT to student_id 1");
        AgentRequest agentRequest = AgentRequest.builder()
                .firstName("Eny")
                .lastName("Skywolker")
                .phoneNo("111111111")
                .country("NOname")
                .city("unknown")
                .timezone("absent")
                .studentId("1")
                .build();

        AgentResponse addedAgent = agentController.create(agentRequest);
        System.out.println(addedAgent);
        System.out.println();

        System.out.println("FIND AGENTs by student id 1");
        List<AgentResponse> foundAgents = agentController.findByStudentId("1");
        System.out.println(foundAgents);

//        System.out.println("DELETE AGENT by id 5");
//        AgentResponse deletedAgent = agentController.deleteById("5");
//        System.out.println(deletedAgent);
    }

    private static void checkStudentController(StudentController studentController) throws SQLException {
        System.out.println("ASSIGN agent 10 to student 16");
        System.out.println(studentController.assignAgent("16", "10"));


//        System.out.println("ALL STUDENTS");
//        List<StudentResponse> students = studentController.findAll();
//        students.forEach(System.out::println);
//        System.out.println();
//
//        System.out.println("ADD NEW STUDENT");
//        StudentRequest studentRequestBuilt = StudentRequest.builder()
//                .firstName("Hero")
//                .lastName("Nakamuro")
//                .phoneNo("14434145")
//                .skype("superHero")
//                .country("Japan")
//                .city("Keko")
//                .defaultPrice("111")
//                .defaultDuration("2222")
//                .timezone("+9")
//                .status("ACTIVE")
//                .build();
//
//        StudentRequest studentRequest = new StudentRequest(
//                "Tracy",
//                "Straus",
//                "333333",
//                "TS",
//                "Germany",
//                "Berlin",
//                "-2",
//                "15000",
//                "100",
//                "ACTIVE");
//        StudentResponse addedStudent = studentController.create(studentRequestBuilt);
//        System.out.println(addedStudent);
//        System.out.println();
//
//        System.out.println("ALL STUDENTS again");
//
//        students = studentController.findAll();
//        students.forEach(System.out::println);
//
//        System.out.println();
//
//        System.out.println("findStudent id 4");
//        StudentResponse findStudent = studentController.findBy(4);
//        System.out.println(findStudent);
//
//        System.out.println();
//
//        System.out.println("Delete student id 13");
//        StudentResponse deletedStudent = studentController.deleteBy(13);
//        System.out.println(deletedStudent);
//
//        System.out.println();
//
//        System.out.println("ALL STUDENTS Again");
//
//        students = studentController.findAll();
//        students.forEach(System.out::println);
//        System.out.println();
//
//
//
//        System.out.println("Update student id 16");
//        StudentRequest updateStudentRequest = new StudentRequest(
//                "Rene",
//                null,
//                null,
//                "Renenene",
//                null,
//                null,
//                null,
//                null,
//                null,
//                "ARCHIVED"
//        );
//
//        StudentResponse updatedStudent = studentController.update(16, updateStudentRequest);
//        System.out.println(updatedStudent);
//        System.out.println();
//
//        System.out.println("ALL STUDENTS Again");
//
//        students = studentController.findAll();
//        students.forEach(System.out::println);
    }
}