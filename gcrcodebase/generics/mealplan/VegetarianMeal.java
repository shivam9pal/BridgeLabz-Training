package week04.gcrcodebase.generics.mealplan;

/**
 * Vegetarian meal plan implementation
 */
public class VegetarianMeal implements MealPlan {
    private String[] allowedIngredients = {
        "Vegetables", "Fruits", "Grains", "Legumes", "Dairy", "Eggs", "Nuts", "Seeds"
    };
    private String[] restrictedIngredients = {
        "Meat", "Fish", "Poultry", "Seafood"
    };
    private int dailyCalories;

    public VegetarianMeal(int dailyCalories) {
        this.dailyCalories = dailyCalories;
    }

    @Override
    public String getMealType() {
        return "Vegetarian";
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
        System.out.println("  Includes: Vegetables, Dairy, Eggs");
        System.out.println("  Excludes: All meat and seafood");
    }

    public int getDailyCalories() {
        return dailyCalories;
    }
}
