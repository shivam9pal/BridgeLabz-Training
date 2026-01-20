package week04.gcrcodebase.generics.university;

import java.util.ArrayList;
import java.util.List;

/**
 * Generic course class to manage different courses with type safety
 */
public class Course<T extends CourseType> {
    private String department;
    private List<T> courses;
    private String semester;

    public Course(String department, String semester) {
        this.department = department;
        this.semester = semester;
        this.courses = new ArrayList<>();
    }

    public void addCourse(T course) {
        courses.add(course);
        System.out.println("Added " + course.getEvaluationType() + " course: " + course.getCourseName());
    }

    public T getCourse(int index) {
        if (index >= 0 && index < courses.size()) {
            return courses.get(index);
        }
        return null;
    }

    public List<T> getAllCourses() {
        return new ArrayList<>(courses);
    }

    public String getDepartment() {
        return department;
    }

    public String getSemester() {
        return semester;
    }

    public int getCourseCount() {
        return courses.size();
    }

    public void displayCourses() {
        System.out.println("\n=== " + department + " - " + semester + " ===");
        System.out.println("Total courses: " + courses.size());
        for (T course : courses) {
            System.out.println(course);
            course.displayEvaluationDetails();
        }
    }

    /**
     * Wildcard method to handle any type of course dynamically
     */
    public static void displayAllCoursesInfo(List<? extends CourseType> courses) {
        System.out.println("\n=== All Courses Overview ===");
        System.out.println("Total courses: " + courses.size());
        for (CourseType course : courses) {
            System.out.println(course);
        }
    }
}
