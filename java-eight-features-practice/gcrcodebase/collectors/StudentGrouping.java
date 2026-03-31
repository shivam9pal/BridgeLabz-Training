package collectors;

import java.util.*;
import java.util.stream.Collectors;

class Student {
	private String name;
	private String gradeLevel;

	public Student(String name, String gradeLevel) {
		this.name = name;
		this.gradeLevel = gradeLevel;
	}

	public String getName() {
		return name;
	}

	public String getGradeLevel() {
		return gradeLevel;
	}
}

public class StudentGrouping {

	public static void main(String[] args) {

		List<Student> students = Arrays.asList(new Student("Rahul", "Grade 10"), new Student("Anita", "Grade 11"),
				new Student("Vikram", "Grade 10"), new Student("Sneha", "Grade 12"), new Student("Karan", "Grade 11"));

		Map<String, List<String>> studentsByGrade = students.stream().collect(Collectors
				.groupingBy(Student::getGradeLevel, Collectors.mapping(Student::getName, Collectors.toList())));

		studentsByGrade.forEach((grade, names) -> System.out.println(grade + " → " + names));
	}
}
