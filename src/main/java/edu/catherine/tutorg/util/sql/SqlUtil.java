package main.java.edu.catherine.tutorg.util.sql;

import main.java.edu.catherine.tutorg.model.entity.client.impl.Student;

import static java.util.Objects.isNull;
import static jdk.internal.joptsimple.internal.Strings.EMPTY;
import static main.java.edu.catherine.tutorg.util.sql.SqlConstants.*;

public class SqlUtil {
    public static String buildUpdateStudentSql(Student student) {
        String resultSql = buildSqlSetPartIfNeed(student.getFirstName(), FIRST_NAME)
                            + buildSqlSetPartIfNeed(student.getLastName(), LAST_NAME)
                            + buildSqlSetPartIfNeed(student.getStudentStatus().getStatusValue(), STATUS)
                            + buildSqlSetPartIfNeed(student.getDefaultLessonParam().getPrice(), DEFAULT_LESSON_PRICE)
                            + buildSqlSetPartIfNeed(student.getDefaultLessonParam().getDuration(), DEFAULT_LESSON_DURATION_MINUTES);

        if (areFieldsForUpdate(resultSql)) {
            resultSql = resultSql.substring(0, resultSql.length() - 1);
            resultSql = UPDATE_STUDENT_SQL_START
                        + resultSql
                        + SQL_WHERE_ID;
        }
        return resultSql;
    }

    public static String buildUpdateContactSql(Student student) {
        String resultSql = buildSqlSetPartIfNeed(student.getLocation().getCountry(), COUNTRY)
                            + buildSqlSetPartIfNeed(student.getLocation().getCity(), CITY)
                            + buildSqlSetPartIfNeed(student.getContact().getPhoneNo(), PHONE_NO)
                            + buildSqlSetPartIfNeed(student.getContact().getSkype(), SKYPE)
                            + buildSqlSetPartIfNeed(student.getLocation().getTimezone(), TIMEZONE);

        if (areFieldsForUpdate(resultSql)) {
            resultSql = resultSql.substring(0, resultSql.length() - 1);
            resultSql = UPDATE_CONTACT_SQL_START
                        + resultSql
                        + SQL_WHERE_STUDENT_ID;
        }
        return resultSql;
    }

    public static boolean areFieldsForUpdate(String string) {
        return !string.isEmpty();
    }

    private static String buildSqlSetPartIfNeed(String newValue, String fieldName) {
        return isNull(newValue)
                ? EMPTY
                : fieldName + SPACE + EQUALS + SPACE + QUOTE + newValue + QUOTE + COMMA;
    }

    private static String buildSqlSetPartIfNeed(Integer newValue, String fieldName) {
        return isNull(newValue)
                ? EMPTY
                : fieldName + SPACE + EQUALS + SPACE + newValue + COMMA;
    }
}
