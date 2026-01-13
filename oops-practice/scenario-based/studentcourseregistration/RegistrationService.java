package week02.scenario.studentcourseregistration;

public interface RegistrationService {

    void registerStudent(Student student);

    void removeStudent(int studentId);

    void enrollStudentInCourse(int studentId, int courseId) throws Exception;

    void dropCourseForStudent(int studentId, int courseId) throws Exception;

    void assignGradeToStudent(int studentId, int courseId, double grade) throws Exception;

    Student getStudent(int studentId);

    Course getCourse(int courseId);

    void displayAllStudents();

    void displayAllCourses();
}
