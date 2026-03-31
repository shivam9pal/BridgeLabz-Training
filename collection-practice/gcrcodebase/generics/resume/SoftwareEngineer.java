package week04.gcrcodebase.generics.resume;

/**
 * Software Engineer job role
 */
public class SoftwareEngineer extends JobRole {
    private String[] programmingLanguages;

    public SoftwareEngineer(int experienceYears, String[] requiredSkills, String[] programmingLanguages) {
        super("Software Engineer", "Engineering", experienceYears, requiredSkills);
        this.programmingLanguages = programmingLanguages;
    }

    public String[] getProgrammingLanguages() {
        return programmingLanguages;
    }

    @Override
    public String getJobCategory() {
        return "Software Development";
    }

    @Override
    public void displayJobRequirements() {
        System.out.println("  Position: " + getRoleName());
        System.out.println("  Category: " + getJobCategory());
        System.out.println("  Experience: " + getExperienceYears() + " years");
        System.out.print("  Programming Languages: ");
        for (int i = 0; i < programmingLanguages.length; i++) {
            System.out.print(programmingLanguages[i]);
            if (i < programmingLanguages.length - 1) System.out.print(", ");
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
