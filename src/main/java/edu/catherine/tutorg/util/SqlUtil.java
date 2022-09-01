package main.java.edu.catherine.tutorg.util;

import main.java.edu.catherine.tutorg.model.client.impl.Student;

import static jdk.internal.joptsimple.internal.Strings.EMPTY;

public class SqlUtil {
    public static final String ID = "id";
    public static final String FIRST_NAME = "first_name";
    public static final String LAST_NAME = "last_name";
    public static final String STATUS = "status";
    private static final String DEFAULT_LESSON_PRICE = "default_lesson_price";
    private static final String DEFAULT_LESSON_DURATION_MINUTES = "default_lesson_duration_minutes";
    public static final String COUNTRY = "country";
    public static final String CITY = "city";
    public static final String PHONE_NO = "phone_no";
    public static final String SKYPE = "skype";
    private static final String TIMEZONE = "timezone";

    private static final String SPACE = " ";
    private static final String EQUALS = "=";
    private static final String COMMA = ",";
    private static final String QUOTE = "'";

    private static final String UPDATE_STUDENT_SQL_START = "UPDATE student SET ";
    private static final String UPDATE_CONTACT_SQL_START = "UPDATE student_contact_info SET ";
    private static final String SQL_WHERE_ID = " WHERE id = ?";

    public static final String CREATE_STUDENT_SQL = "INSERT INTO student (first_name, last_name, status, default_lesson_price, default_lesson_duration_minutes) VALUES (?,?,?,?,?)";
    public static final String CREATE_CONTACT_SQL = "INSERT INTO student_contact_info (country, city, phone_no, skype, timezone, student_id) VALUES (?,?,?,?,?,?)";
    public static final String FIND_ALL_SQL = "SELECT student.id as id, student.first_name as first_name, student.last_name as last_name, student.status as status, student_contact_info.phone_no as phone_no, student_contact_info.skype as skype, student_contact_info.country as country, student_contact_info.city as city FROM student JOIN student_contact_info ON student.id = student_contact_info.student_id";
    // DONE: 30.08.2022 findById is the case of findAll
    public static final String FIND_BY_ID = FIND_ALL_SQL + "WHERE student.id = ?";
    public static final String DELETE_STUDENT_BY_ID = "DELETE FROM student WHERE id = ?" ;

    public static String getUpdateStudentSql(Student student) {
        String resultSql = generateSqlPartIfNeed(student.getFirstName(), FIRST_NAME)
                            + generateSqlPartIfNeed(student.getLastName(), LAST_NAME)
                            + generateSqlPartIfNeed(student.getStudentStatus().getStatus(), STATUS)
                            + generateSqlPartIfNeed(student.getDefaultLessonParam().getPrice(), DEFAULT_LESSON_PRICE)
                            + generateSqlPartIfNeed(student.getDefaultLessonParam().getDuration(), DEFAULT_LESSON_DURATION_MINUTES);

        if (availableFieldForUpdate(resultSql)) {
            resultSql = resultSql.substring(0, resultSql.length() - 1);
            resultSql = UPDATE_STUDENT_SQL_START
                        + resultSql
                        + SQL_WHERE_ID;
        }
        return resultSql;
    }

    public static String getUpdateContactSql(Student student) {
        String resultSql = generateSqlPartIfNeed(student.getLocation().getCountry(), COUNTRY)
                            + generateSqlPartIfNeed(student.getLocation().getCity(), CITY)
                            + generateSqlPartIfNeed(student.getContact().getPhoneNo(), PHONE_NO)
                            + generateSqlPartIfNeed(student.getContact().getSkype(), SKYPE)
                            + generateSqlPartIfNeed(student.getLocation().getTimezone(), TIMEZONE);

        if (availableFieldForUpdate(resultSql)) {
            resultSql = resultSql.substring(0, resultSql.length() - 1);
            resultSql = UPDATE_CONTACT_SQL_START
                        + resultSql
                        + SQL_WHERE_ID;
        }
        return resultSql;
    }

    public static boolean availableFieldForUpdate(String string) {
        return ! string.isEmpty();
    }

    private static String generateSqlPartIfNeed(String fieldValue, String fieldName) {
        if (fieldValue != null) {
            return fieldName + SPACE + EQUALS + SPACE + QUOTE + fieldValue + QUOTE + COMMA;
        }
        return EMPTY;
    }

    private static String generateSqlPartIfNeed(Integer fieldValue, String fieldName) {
        if (fieldValue != null) {
            return fieldName + SPACE + EQUALS + SPACE + fieldValue + COMMA;
        }
        return EMPTY;
    }
}
