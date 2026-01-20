package week04.gcrcodebase.generics.university;

import java.util.ArrayList;
import java.util.List;

/**
 * Demo class for Multi-Level University Course Management System
 */
public class UniversityDemo {
    public static void main(String[] args) {
        // Create course collections for different departments
        Course<ExamCourse> examCourses = new Course<>("Computer Science", "Spring 2026");
        Course<AssignmentCourse> assignmentCourses = new Course<>("Software Engineering", "Spring 2026");
        Course<ResearchCourse> researchCourses = new Course<>("Data Science", "Spring 2026");

        // Add exam-based courses
        examCourses.addCourse(new ExamCourse("Data Structures", "CS201", 4, 40, 60));
        examCourses.addCourse(new ExamCourse("Algorithms", "CS301", 4, 30, 70));
        examCourses.addCourse(new ExamCourse("Operating Systems", "CS401", 3, 35, 65));

        // Add assignment-based courses
        assignmentCourses.addCourse(new AssignmentCourse("Web Development", "SE202", 3, 5, 40));
        assignmentCourses.addCourse(new AssignmentCourse("Mobile App Development", "SE302", 3, 6, 35));

        // Add research-based courses
        researchCourses.addCourse(new ResearchCourse("Machine Learning", "DS501", 4, 
                                  "Deep Learning Applications", 50));
        researchCourses.addCourse(new ResearchCourse("Big Data Analytics", "DS502", 4, 
                                  "Distributed Computing", 45));

        // Display courses by type
        examCourses.displayCourses();
        assignmentCourses.displayCourses();
        researchCourses.displayCourses();

        // Use wildcard to display all courses regardless of type
        List<CourseType> allCourses = new ArrayList<>();
        allCourses.addAll(examCourses.getAllCourses());
        allCourses.addAll(assignmentCourses.getAllCourses());
        allCourses.addAll(researchCourses.getAllCourses());

        Course.displayAllCoursesInfo(allCourses);

        // Calculate total credits
        int totalCredits = 0;
        for (CourseType course : allCourses) {
            totalCredits += course.getCredits();
        }
        System.out.println("\nTotal Credits Offered: " + totalCredits);
    }
}
