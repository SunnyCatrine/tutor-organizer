package main.java.edu.catherine.tutorg.dao;

import main.java.edu.catherine.tutorg.exception.DaoException;
import main.java.edu.catherine.tutorg.model.client.StudentStatus;
import main.java.edu.catherine.tutorg.model.client.ext.Student;
import main.java.edu.catherine.tutorg.model.lesson.SubjectBlock;

import java.sql.*;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class ClientDao {
    private static final ClientDao INSTANCE = new ClientDao();
    private static final String CREATE_STUDENT_SQL = "INSERT INTO student (first_name, last_name, status) VALUES (?,?,?)";
    private static final String FIND_ALL_SQL = "SELECT student.id, student.first_name, student.last_name, student.status FROM student";

    private ClientDao() {
    }

    public static ClientDao getInstance() {
        return INSTANCE;
    }

//    public Student createStudent(Student student, Connection connection) throws SQLException {
//        PreparedStatement studentCreateStatement = null;
//        Statement studentParameterStatement = null;
//        String CONTACT_CREATE_SQL = "INSERT INTO student_contact_info (country, city, phone_no, skype, timezone, student_id) VALUES ("
//                + student.getLocation().getCountry() + ", "
//                + student.getLocation().getCity() + ", "
//                + student.getContact().getPhoneNo() + ", "
//                + student.getContact().getSkype() + ", "
//                + student.getLocation().getTimezone() + ", "
//                + student.getClientId()
//                +")";
//        String subjectCreateSql = "INSERT INTO subject (subject_name, student_id) VALUES (";
//        String defaultParamCreateSql = "INSERT INTO lesson_default_param (price, duration, student_id) VALUES ("
//                + student.getDefaultLessonParam().getPrice() + ","
//                + student.getDefaultLessonParam().getDuration() + ","
//                + student.getClientId()
//                + ")";
//        String lessonsPeriodCreateSql = "INSERT INTO lessons_period (first_lesson_date, last_lesson_date, student_id) VALUES ("
//                + Date.valueOf(student.getLessonsPeriod().getFirstLessonDate()) + ","
//                + Date.valueOf(student.getLessonsPeriod().getLastLessonDate()) + ","
//                + student.getClientId()
//                + ")";
//        String scheduleUnitCreateSql = "INSERT INTO schedule_unit (day_of_week, time, duration, price, student_id) VALUES (";
//
//        try {studentCreateStatement = connection.prepareStatement(STUDENT_CREATE_SQL, Statement.RETURN_GENERATED_KEYS);
//            studentParameterStatement = connection.createStatement();
//
//
//                studentCreateStatement.setString(1, student.getFirstName());
//                studentCreateStatement.setString(2, student.getLastName());
//                studentCreateStatement.setString(3, StudentStatus.ACTIVE.getStatus());
//
//                studentCreateStatement.executeUpdate();
//
//                ResultSet generatedKeys = studentCreateStatement.getGeneratedKeys();
//                if (generatedKeys.next()) {
//                    student.setClientId(generatedKeys.getInt("id"));
//                }
//
//                studentParameterStatement.addBatch(CONTACT_CREATE_SQL);
//
//                for (SubjectBlock subj: student.getSubjects()) {
//                    subjectCreateSql = subjectCreateSql
//                            + subj.getSubjectName() + ","
//                            + student.getClientId()
//                            + ")";
//                    studentParameterStatement.addBatch(subjectCreateSql);
//                }
//
//                studentParameterStatement.addBatch(defaultParamCreateSql);
//                studentParameterStatement.addBatch(lessonsPeriodCreateSql);
//
//            for (Map.Entry<DayOfWeek, LocalTime> entry: student.getSchedule().entrySet()) {
//                scheduleUnitCreateSql = scheduleUnitCreateSql
//                        + entry.getKey() + ","
//                        + entry.getValue() + ","
//                        + student.getDefaultLessonParam().getDuration() + ","
//                        + student.getDefaultLessonParam().getPrice() + ","
//                        + student.getClientId()
//                        + ")";
//                studentParameterStatement.addBatch(scheduleUnitCreateSql);
//            }
//
//                studentParameterStatement.executeBatch();
//                connection.commit();
//
//                return student;
//            } catch (Exception e) {
//                throw e;
//            } finally {
//                if (studentCreateStatement != null) {
//                    studentCreateStatement.close();
//                }
//                if (studentParameterStatement != null) {
//                    studentParameterStatement.close();
//                }
//            }
//    }

    public List<Student> findAllStudents(Connection connection) {
        try(PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_SQL)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            List<Student> resultList = new ArrayList<>();
            while (resultSet.next()) {
                Student student = buildStudent(resultSet);
                resultList.add(student);
//                System.out.println(student);
            }
            return resultList;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    private Student buildStudent(ResultSet resultSet) throws SQLException {
        return new Student(
                resultSet.getInt("id"),
                resultSet.getString("first_name"),
                resultSet.getString("last_name"),
                StudentStatus.valueOf(resultSet.getString("status")));
    }

    public Student createStudent(Student studentRequest, Connection connection) throws SQLException {
        Student studentResponse = studentRequest;
        try(PreparedStatement preparedStatement = connection.prepareStatement(CREATE_STUDENT_SQL, Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, studentRequest.getFirstName());
            preparedStatement.setString(2,studentRequest.getLastName());
            preparedStatement.setString(3,studentRequest.getStudentStatus().getStatus());
            preparedStatement.executeUpdate();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                studentResponse.setClientId(resultSet.getInt("id"));
            }
            return  studentResponse;
        } catch (Exception e) {
            throw e;
        }
    }
}
