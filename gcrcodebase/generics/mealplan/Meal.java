package week04.gcrcodebase.generics.mealplan;

import java.util.ArrayList;
import java.util.List;

/**
 * Generic class to handle different meal plans with type safety
 */
public class Meal<T extends MealPlan> {
    private String planName;
    private List<T> meals;
    private int durationDays;

    public Meal(String planName, int durationDays) {
        this.planName = planName;
        this.durationDays = durationDays;
        this.meals = new ArrayList<>();
    }

    public void addMeal(T meal) {
        meals.add(meal);
        System.out.println("Added " + meal.getMealType() + " meal plan");
    }

    public List<T> getAllMeals() {
        return new ArrayList<>(meals);
    }

    public String getPlanName() {
        return planName;
    }

    public int getDurationDays() {
        return durationDays;
    }

    /**
     * Generic method to validate and generate a personalized meal plan dynamically
     */
    public static <T extends MealPlan> boolean validateAndGenerate(T mealPlan, String userName) {
        System.out.println("\n=== Validating Meal Plan for " + userName + " ===");
        
        // Validation logic
        if (mealPlan == null) {
            System.out.println("ERROR: Invalid meal plan");
            return false;
        }

        String[] allowed = mealPlan.getAllowedIngredients();
        String[] restricted = mealPlan.getRestrictedIngredients();

        if (allowed == null || allowed.length == 0) {
            System.out.println("ERROR: No allowed ingredients specified");
            return false;
        }

        // Display validation success
        System.out.println("✓ Meal plan validated successfully");
        System.out.println("\n=== Personalized Meal Plan Generated ===");
        System.out.println("User: " + userName);
        mealPlan.displayMealInfo();
        
        System.out.println("\nAllowed Ingredients (" + allowed.length + "):");
        for (String ingredient : allowed) {
            System.out.println("  • " + ingredient);
        }

        System.out.println("\nRestricted Ingredients (" + restricted.length + "):");
        for (String ingredient : restricted) {
            System.out.println("  • " + ingredient);
        }

        return true;
    }

    public void displayMealPlan() {
        System.out.println("\n=== " + planName + " (" + durationDays + " days) ===");
        System.out.println("Total meal types: " + meals.size());
        for (T meal : meals) {
            meal.displayMealInfo();
            System.out.println();
        }
    }
}
