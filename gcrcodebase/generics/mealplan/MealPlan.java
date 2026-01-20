package week04.gcrcodebase.generics.mealplan;

/**
 * Interface for all meal plan types
 */
public interface MealPlan {
    String getMealType();
    String[] getAllowedIngredients();
    String[] getRestrictedIngredients();
    void displayMealInfo();
}
