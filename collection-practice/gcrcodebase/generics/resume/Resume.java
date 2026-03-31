package week04.gcrcodebase.generics.resume;

import java.util.ArrayList;
import java.util.List;

/**
 * Generic resume processing class with type safety
 */
public class Resume<T extends JobRole> {
    private String candidateName;
    private List<T> jobRoles;
    private String email;
  
    public Resume(String candidateName, String email) {
        this.candidateName = candidateName;
        this.email = email;
        this.jobRoles = new ArrayList<>();
    }

    public void addJobRole(T jobRole) {
        jobRoles.add(jobRole);
        System.out.println("Added job role: " + jobRole.getRoleName() + " for " + candidateName);
    }

    public List<T> getJobRoles() {
        return new ArrayList<>(jobRoles);
    }

    public String getCandidateName() {
        return candidateName;
    }

    public String getEmail() {
        return email;
    }

    public void displayResume() {
        System.out.println("\n=== Resume: " + candidateName + " ===");
        System.out.println("Email: " + email);
        System.out.println("Applying for " + jobRoles.size() + " position(s):");
        for (T role : jobRoles) {
            System.out.println("  - " + role.getRoleName());
        }
    }

    /**
     * Wildcard method to handle multiple job roles in the screening pipeline
     */
    public static void screenResumes(List<? extends JobRole> jobRoles, String candidateName) {
        System.out.println("\n=== Screening Resume for: " + candidateName + " ===");
        System.out.println("Processing " + jobRoles.size() + " job role(s)...\n");

        for (JobRole role : jobRoles) {
            System.out.println("--- Screening for: " + role.getRoleName() + " ---");
            role.displayJobRequirements();
            System.out.println("  Status: ✓ Resume processed");
            System.out.println();
        }

        System.out.println("=== Screening Complete ===");
        System.out.println("Total positions screened: " + jobRoles.size());
    }

    public int getJobRoleCount() {
        return jobRoles.size();
    }
}
