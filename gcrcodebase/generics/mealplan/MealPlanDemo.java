package week04.gcrcodebase.generics.mealplan;

/**
 * Demo class for Personalized Meal Plan Generator
 */
public class MealPlanDemo {
    public static void main(String[] args) {
        System.out.println("=== Personalized Meal Plan Generator ===\n");

        // Create different meal plans
        VegetarianMeal vegetarianMeal = new VegetarianMeal(2000);
        VeganMeal veganMeal = new VeganMeal(1800);
        KetoMeal ketoMeal = new KetoMeal(1600, 20);
        HighProteinMeal highProteinMeal = new HighProteinMeal(2200, 150);

        // Validate and generate meal plans for different users
        Meal.validateAndGenerate(vegetarianMeal, "Alice Johnson");
        Meal.validateAndGenerate(veganMeal, "Bob Smith");
        Meal.validateAndGenerate(ketoMeal, "Carol Davis");
        Meal.validateAndGenerate(highProteinMeal, "David Wilson");

        // Create meal plan collections
        System.out.println("\n\n=== Creating Meal Plan Collections ===");
        
        Meal<VegetarianMeal> vegetarianPlan = new Meal<>("Vegetarian 30-Day Plan", 30);
        vegetarianPlan.addMeal(new VegetarianMeal(2000));
        vegetarianPlan.addMeal(new VegetarianMeal(1900));

        Meal<VeganMeal> veganPlan = new Meal<>("Vegan 21-Day Plan", 21);
        veganPlan.addMeal(new VeganMeal(1800));
        veganPlan.addMeal(new VeganMeal(1750));

        Meal<KetoMeal> ketoPlan = new Meal<>("Keto 14-Day Plan", 14);
        ketoPlan.addMeal(new KetoMeal(1600, 20));
        ketoPlan.addMeal(new KetoMeal(1700, 25));

        // Display meal plans
        vegetarianPlan.displayMealPlan();
        veganPlan.displayMealPlan();
        ketoPlan.displayMealPlan();

        // Test invalid meal plan
        System.out.println("\n=== Testing Invalid Meal Plan ===");
        Meal.validateAndGenerate(null, "Invalid User");
    }
}
