package week04.gcrcodebase.generics.resume;

/**
 * Abstract base class for all job roles
 */
public abstract class JobRole {
    private String roleName;
    private String department;
    private int experienceYears;
    private String[] requiredSkills;

    public JobRole(String roleName, String department, int experienceYears, String[] requiredSkills) {
        this.roleName = roleName;
        this.department = department;
        this.experienceYears = experienceYears;
        this.requiredSkills = requiredSkills;
    }

    public String getRoleName() {
        return roleName;
    }

    public String getDepartment() {
        return department;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public String[] getRequiredSkills() {
        return requiredSkills;
    }

    public abstract String getJobCategory();
    
    public abstract void displayJobRequirements();

    @Override
    public String toString() {
        return roleName + " (" + department + ") - " + experienceYears + " years experience required";
    }
}
