package week04.gcrcodebase.generics.resume;

/**
 * Product Manager job role
 */
public class ProductManager extends JobRole {
    private String[] productAreas;

    public ProductManager(int experienceYears, String[] requiredSkills, String[] productAreas) {
        super("Product Manager", "Product Management", experienceYears, requiredSkills);
        this.productAreas = productAreas;
    }

    public String[] getProductAreas() {
        return productAreas;
    }

    @Override
    public String getJobCategory() {
        return "Product & Strategy";
    }

    @Override
    public void displayJobRequirements() {
        System.out.println("  Position: " + getRoleName());
        System.out.println("  Category: " + getJobCategory());
        System.out.println("  Experience: " + getExperienceYears() + " years");
        System.out.print("  Product Areas: ");
        for (int i = 0; i < productAreas.length; i++) {
            System.out.print(productAreas[i]);
            if (i < productAreas.length - 1) System.out.print(", ");
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
