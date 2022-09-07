package main.java.edu.catherine.tutorg.dao;

import main.java.edu.catherine.tutorg.model.client.Contact;
import main.java.edu.catherine.tutorg.model.client.Location;
import main.java.edu.catherine.tutorg.model.client.StudentStatus;
import main.java.edu.catherine.tutorg.model.client.impl.Student;
import main.java.edu.catherine.tutorg.model.lesson.LessonParam;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static main.java.edu.catherine.tutorg.util.sql.SqlConstants.*;

public final class StudentDao {
    private static final StudentDao INSTANCE = new StudentDao();


    public Student create(Connection connection, Student student) throws SQLException {
        Student resultStudent = buildStudent(student);

        try (PreparedStatement studentCreate = connection.prepareStatement(CREATE_STUDENT_SQL, Statement.RETURN_GENERATED_KEYS);
             PreparedStatement contactCreate = connection.prepareStatement(CREATE_CONTACT_SQL)) {

            studentCreate.setString(1, student.getFirstName());
            studentCreate.setString(2, student.getLastName());
            studentCreate.setString(3, StudentStatus.ACTIVE.getStatusValue());
            studentCreate.setInt(4, student.getDefaultLessonParam().getPrice());
            studentCreate.setInt(5, student.getDefaultLessonParam().getDuration());

            studentCreate.executeUpdate();
            ResultSet resultSet = studentCreate.getGeneratedKeys();
            if (resultSet.next()) {
                resultStudent.setClientId(resultSet.getInt(ID));
                resultStudent.setStudentStatus(StudentStatus.valueOf(resultSet.getString(STATUS)));
            }

            contactCreate.setString(1, student.getLocation().getCountry());
            contactCreate.setString(2, student.getLocation().getCity());
            contactCreate.setString(3, student.getContact().getPhoneNo());
            contactCreate.setString(4, student.getContact().getSkype());
            contactCreate.setString(5, student.getLocation().getTimezone());
            contactCreate.setInt(6, resultStudent.getClientId());

            contactCreate.executeUpdate();

            return resultStudent;
        }
    }

    public List<Student> findAll(Connection connection) throws SQLException {
        List<Student> resultList = new ArrayList<>();
        try (PreparedStatement findAllStudents = connection.prepareStatement(FIND_ALL_SQL)) {
            findAllStudents.executeQuery();
            ResultSet resultSet = findAllStudents.getResultSet();
            while (resultSet.next()) {
                resultList.add(buildStudent(resultSet));
            }
            return resultList;
        }
    }



    public Student findBy(Connection connection, Integer studentId) throws SQLException {
        Student resultStudent = null;
        try (PreparedStatement findStudentById = connection.prepareStatement(FIND_BY_ID)) {

            findStudentById.setInt(1,studentId);

            findStudentById.executeQuery();
            ResultSet resultSet = findStudentById.getResultSet();
            if (resultSet.next()) {
                resultStudent = buildStudent(resultSet);
            }
            return resultStudent;
        }
    }

    public Student deleteBy(Connection connection, Integer studentId) throws SQLException {
        Student resultStudent = findBy(connection, studentId);
        try (PreparedStatement deleteStudentById = connection.prepareStatement(DELETE_STUDENT_BY_ID)) {
            deleteStudentById.setInt(1, studentId);
            if (deleteStudentById.executeUpdate()>0) {
                return resultStudent;
            }
            return null;
        }
    }

//    public Student update(Connection connection, Integer id, Student studentRequest) throws SQLException {
//        String updateStudentSql = buildUpdateStudentSql(studentRequest);
//        String updateContactSql = buildUpdateContactSql(studentRequest);
//
//        // DONE: 30.08.2022 name of condition is bad
//        if (availableFieldForUpdate(updateStudentSql)) {
//            // DONE: 30.08.2022 not camel case
//            try (PreparedStatement updateStudentById = connection.prepareStatement(updateStudentSql)) {
//                updateStudentById.setInt(1, id);
//                updateStudentById.executeUpdate();
//            }
//        }
//        if (! updateContactSql.isEmpty()) {
//            try (PreparedStatement updateContactByStudentID = connection.prepareStatement(updateContactSql)) {
//                updateContactByStudentID.setInt(1, id);
//                updateContactByStudentID.executeUpdate();
//            }
//        }
//        return findBy(connection, id);
//    }

    public static StudentDao getInstance() {
        return INSTANCE;
    }

    private StudentDao() {
    }



    private Student buildStudent(ResultSet resultSet) throws SQLException {
        Contact contact = new Contact(resultSet.getString(PHONE_NO),
                resultSet.getString(SKYPE));
        Location location = new Location(
                resultSet.getString(COUNTRY),
                resultSet.getString(CITY),
                resultSet.getString(TIMEZONE));
        LessonParam defaultLessonParam = new LessonParam(
                resultSet.getInt(DEFAULT_LESSON_PRICE),
                resultSet.getInt(DEFAULT_LESSON_DURATION_MINUTES));
        return new Student(
                resultSet.getInt(ID),
                resultSet.getString(FIRST_NAME),
                resultSet.getString(LAST_NAME),
                contact,
                location,
                defaultLessonParam,
                StudentStatus.valueOf(resultSet.getString(STATUS)));
    }

    private Student buildStudent (Student student) {
        return new Student(student.getFirstName(),
                student.getLastName(),
                student.getContact(),
                student.getLocation(),
                student.getDefaultLessonParam(),
                student.getStudentStatus());
    }




//    public List<Student> findAllStudents(Connection connection) {
//        try(PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_SQL)) {
//            ResultSet resultSet = preparedStatement.executeQuery();
//
//            List<Student> resultList = new ArrayList<>();
//            while (resultSet.next()) {
//                Student student = buildStudent(resultSet);
//                resultList.add(student);
////                System.out.println(student);
//            }
//            return resultList;
//        } catch (SQLException e) {
//            throw new DaoException(e);
//        }
//    }
//
//    private Student buildStudent(ResultSet resultSet) throws SQLException {
//        return new Student(
//                resultSet.getInt("id"),
//                resultSet.getString("first_name"),
//                resultSet.getString("last_name"),
//                StudentStatus.valueOf(resultSet.getString("status")));
//    }
//
//    public Student createStudent(Student studentRequest, Connection connection) throws SQLException {
//        Student studentResponse = studentRequest;
//        try(PreparedStatement preparedStatement = connection.prepareStatement(CREATE_STUDENT_SQL, Statement.RETURN_GENERATED_KEYS)) {
//
//            preparedStatement.setString(1, studentRequest.getFirstName());
//            preparedStatement.setString(2,studentRequest.getLastName());
//            preparedStatement.setString(3,studentRequest.getStudentStatus().getStatus());
//            preparedStatement.executeUpdate();
//
//            ResultSet resultSet = preparedStatement.getGeneratedKeys();
//            if (resultSet.next()) {
//                studentResponse.setClientId(resultSet.getInt("id"));
//            }
//            return  studentResponse;
//        } catch (Exception e) {
//            throw e;
//        }

//    }

}
