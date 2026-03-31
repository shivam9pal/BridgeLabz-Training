package week02.scenario;

import java.util.ArrayList;
import java.util.List;

class InvalidMarkException extends Exception{
	InvalidMarkException(String message) {
        super(message);
    }
}

class Student{
	private String name;
	private String[] subjects;
	private int[] marks;
	
	Student(String name,String[] subjects,int[] marks)throws InvalidMarkException{
		if(subjects.length!=marks.length) {
			throw new InvalidMarkException("Subjects and marks count mismatch !!");
		}
		
		//validate marks
		validateMarks(marks);
        this.name = name;
        this.subjects = subjects;
        this.marks = marks;
	}
	
	public String getName() {
        return name;
    }

    public String[] getSubjects() {
        return subjects;
    }

    public int[] getMarks() {
        return marks;
    }
	
	//validate marks
	private void validateMarks(int[] marks)
            throws InvalidMarkException {

        for (int mark : marks) {
            if (mark < 0 || mark > 100) {
                throw new InvalidMarkException(
                        "Invalid mark found: " + mark +
                        ". Marks must be between 0 and 100."
                );
            }
        }
    }
}


//Report Genrator another class 
class ReportGenrator{
	//calculate average
	public static double calculateAverage(int[] marks) {
		int sum = 0;
        for (int m : marks) {
            sum += m;
        }
        return (double) sum / marks.length;
	}
	
	
	//assign grade
	public static String assignGrade(double average) {
		if (average >= 90) return "A";
        else if (average >= 75) return "B";
        else if (average >= 60) return "C";
        else return "D";
	}
	
	
	//display Report card
	public static void dispayReportCard(Student student) {
		String[] subjects = student.getSubjects();
        int[] marks = student.getMarks();

        System.out.println("=================================");
        System.out.printf("Report Card for: %s%n", student.getName());
        System.out.println("---------------------------------");

        for (int i = 0; i < subjects.length; i++) {
            System.out.printf("%-15s : %3d%n",
                    subjects[i], marks[i]);
        }

        double avg = calculateAverage(marks);
        String grade = assignGrade(avg);

        System.out.println("---------------------------------");
        System.out.printf("Average Marks : %.2f%n", avg);
        System.out.printf("Grade         : %s%n", grade);
        System.out.println("=================================");
	}
}
public class StudentReportGenrator {

	public static void main(String[] args) {
		List<Student> students=new ArrayList<>();
		try {
			students.add(new Student("Shivam",new String[] {"Math","Physics","Chemistry"},new int[] {86,90,88}));
			
			students.add(new Student("Shivam",new String[] {"Math","Physics","Chemistry"},new int[] {60,9,78}));
			
			students.add(new Student("Shivam",new String[] {"Math","Physics","Chemistry"},new int[] {86,88}));
		}catch(InvalidMarkException e) {
			System.out.print("Error"+e.getMessage());
		}
		
		
		for (Student s : students) {
			ReportGenrator.dispayReportCard(s);
        }

	}

}
