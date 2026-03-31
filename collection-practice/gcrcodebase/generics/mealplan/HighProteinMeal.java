package week04.gcrcodebase.generics.mealplan;

/**
 * High-Protein meal plan implementation
 */
public class HighProteinMeal implements MealPlan {
    private String[] allowedIngredients = {
        "Lean meat", "Fish", "Eggs", "Greek yogurt", "Protein powder", "Legumes", "Quinoa"
    };
    private String[] restrictedIngredients = {
        "Excessive fats", "High-sugar foods", "Processed foods"
    };
    private int dailyCalories;
    private int proteinGrams;

    public HighProteinMeal(int dailyCalories, int proteinGrams) {
        this.dailyCalories = dailyCalories;
        this.proteinGrams = proteinGrams;
    }

    @Override
    public String getMealType() {
        return "High-Protein";
    }

    @Override
    public String[] getAllowedIngredients() {
        return allowedIngredients;
    }

    @Override
    public String[] getRestrictedIngredients() {
        return restrictedIngredients;
    }

    @Override
    public void displayMealInfo() {
        System.out.println("  Meal Type: " + getMealType());
        System.out.println("  Daily Calories: " + dailyCalories);
        System.out.println("  Protein Target: " + proteinGrams + "g/day");
        System.out.println("  Includes: Lean proteins, moderate carbs");
        System.out.println("  Excludes: Processed foods");
    }

    public int getDailyCalories() {
        return dailyCalories;
    }

    public int getProteinGrams() {
        return proteinGrams;
    }
}
