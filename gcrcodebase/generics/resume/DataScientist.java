package week04.gcrcodebase.generics.resume;
/**
 * Data Scientist job role
 */
public class DataScientist extends JobRole {
    private String[] analyticsTools;

    public DataScientist(int experienceYears, String[] requiredSkills, String[] analyticsTools) {
        super("Data Scientist", "Data Science", experienceYears, requiredSkills);
        this.analyticsTools = analyticsTools;
    }

    public String[] getAnalyticsTools() {
        return analyticsTools;
    }

    @Override
    public String getJobCategory() {
        return "Data & Analytics";
    }

    @Override
    public void displayJobRequirements() {
        System.out.println("  Position: " + getRoleName());
        System.out.println("  Category: " + getJobCategory());
        System.out.println("  Experience: " + getExperienceYears() + " years");
        System.out.print("  Analytics Tools: ");
        for (int i = 0; i < analyticsTools.length; i++) {
            System.out.print(analyticsTools[i]);
            if (i < analyticsTools.length - 1) System.out.print(", ");
        }
        System.out.println();
        System.out.print("  Required Skills: ");
        String[] skills = getRequiredSkills();
        for (int i = 0; i < skills.length; i++) {
            System.out.print(skills[i]);
            if (i < skills.length - 1) System.out.print(", ");
        }
        System.out.println();
    }
}
