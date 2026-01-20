package week04.gcrcodebase.generics.mealplan;

/**
 * Keto meal plan implementation
 */
public class KetoMeal implements MealPlan {
    private String[] allowedIngredients = {
        "Meat", "Fish", "Eggs", "Low-carb vegetables", "Healthy fats", "Cheese", "Nuts"
    };
    private String[] restrictedIngredients = {
        "Grains", "Sugar", "Bread", "Pasta", "High-carb fruits", "Potatoes"
    };
    private int dailyCalories;
    private int maxCarbsGrams;

    public KetoMeal(int dailyCalories, int maxCarbsGrams) {
        this.dailyCalories = dailyCalories;
        this.maxCarbsGrams = maxCarbsGrams;
    }

    @Override
    public String getMealType() {
        return "Keto";
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
        System.out.println("  Max Carbs: " + maxCarbsGrams + "g/day");
        System.out.println("  Includes: High-fat, moderate protein");
        System.out.println("  Excludes: High-carb foods");
    }

    public int getDailyCalories() {
        return dailyCalories;
    }

    public int getMaxCarbsGrams() {
        return maxCarbsGrams;
    }
}
