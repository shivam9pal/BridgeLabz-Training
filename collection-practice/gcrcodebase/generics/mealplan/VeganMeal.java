package week04.gcrcodebase.generics.mealplan;

/**
 * Vegan meal plan implementation
 */
public class VeganMeal implements MealPlan {
    private String[] allowedIngredients = {
        "Vegetables", "Fruits", "Grains", "Legumes", "Nuts", "Seeds", "Plant-based proteins"
    };
    private String[] restrictedIngredients = {
        "Meat", "Fish", "Poultry", "Seafood", "Dairy", "Eggs", "Honey"
    };
    private int dailyCalories;

    public VeganMeal(int dailyCalories) {
        this.dailyCalories = dailyCalories;
    }

    @Override
    public String getMealType() {
        return "Vegan";
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
        System.out.println("  Includes: Vegetables, Fruits, Plant-based proteins");
        System.out.println("  Excludes: All animal products");
    }

    public int getDailyCalories() {
        return dailyCalories;
    }
}
