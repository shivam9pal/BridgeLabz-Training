package week04.gcrcodebase.generics.resume;

import java.util.ArrayList;
import java.util.List;

/**
 * Demo class for AI-Driven Resume Screening System
 */
public class ResumeScreeningDemo {
    
    private static String repeatChar(String str, int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(str);
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
        System.out.println("=== AI-Driven Resume Screening System ===\n");

        // Create job roles for different positions
        SoftwareEngineer seRole = new SoftwareEngineer(
            3,
            new String[]{"Problem Solving", "Team Collaboration", "Agile Development"},
            new String[]{"Java", "Python", "JavaScript", "SQL"}
        );

        DataScientist dsRole = new DataScientist(
            5,
            new String[]{"Statistical Analysis", "Machine Learning", "Data Visualization"},
            new String[]{"Python", "R", "TensorFlow", "Pandas", "Tableau"}
        );

        ProductManager pmRole = new ProductManager(
            4,
            new String[]{"Strategic Planning", "Stakeholder Management", "Market Analysis"},
            new String[]{"SaaS", "Mobile Apps", "E-commerce"}
        );

        // Create resumes for different candidates
        Resume<SoftwareEngineer> johnResume = new Resume<>("John Smith", "john.smith@email.com");
        johnResume.addJobRole(seRole);

        Resume<DataScientist> emilyResume = new Resume<>("Emily Johnson", "emily.j@email.com");
        emilyResume.addJobRole(dsRole);

        Resume<ProductManager> michaelResume = new Resume<>("Michael Brown", "michael.b@email.com");
        michaelResume.addJobRole(pmRole);

        // Display individual resumes
        johnResume.displayResume();
        emilyResume.displayResume();
        michaelResume.displayResume();

        // Screen resumes using wildcard method
        System.out.println("\n\n" + repeatChar("=", 60));
        System.out.println("SCREENING PROCESS");
        System.out.println(repeatChar("=", 60));

        Resume.screenResumes(johnResume.getJobRoles(), johnResume.getCandidateName());
        Resume.screenResumes(emilyResume.getJobRoles(), emilyResume.getCandidateName());
        Resume.screenResumes(michaelResume.getJobRoles(), michaelResume.getCandidateName());

        // Demonstrate handling multiple job roles in one screening
        System.out.println("\n" + repeatChar("=", 60));
        System.out.println("COMBINED SCREENING FOR ALL POSITIONS");
        System.out.println(repeatChar("=", 60));

        List<JobRole> allRoles = new ArrayList<>();
        allRoles.addAll(johnResume.getJobRoles());
        allRoles.addAll(emilyResume.getJobRoles());
        allRoles.addAll(michaelResume.getJobRoles());

        Resume.screenResumes(allRoles, "All Candidates");

        // Summary
        System.out.println("\n=== Screening Summary ===");
        System.out.println("Total candidates processed: 3");
        System.out.println("Total positions screened: " + allRoles.size());
        System.out.println("System Status: ✓ All resumes processed successfully");
    }
}
