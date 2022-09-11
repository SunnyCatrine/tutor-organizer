package main.java.edu.catherine.tutorg.model.entity.lesson;

public enum SubjectBlock {
    MATH5("MATH5"),
    MATH6("MATH6"),
    MATH7("MATH7"),
    MATH8("MATH8"),
    MATH9("MATH9"),
    MATH10("MATH10"),
    MATH11("MATH11"),
    OGE8("OGE8"),
    OGE9("OGE8"),
    EGE10("EGE10"),
    EGE11("EGE11"),
    HIGH_MATH("HIGH_MATH"),
    MATH_ANALYSIS("MATH_ANALYSIS"),
    LINEAR_ALGEBRA("LINEAR_ALGEBRA"),
    ANALYTIC_GEOMETRY("ANALYTIC_GEOMETRY");
    
    private String subjectName;

    SubjectBlock(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getSubjectName() {
        return subjectName;
    }
}
