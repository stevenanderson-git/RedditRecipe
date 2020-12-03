import java.util.ArrayList;

/**
 * From Reddit:
 * https://www.reddit.com/r/javahelp/comments/k5k5mk/reading_from_a_txt_file_and_storing_it_to/
 * 
 * @author u/lordwerwath
 */
public class Recipe {
    private String recipeName;
    private String recipeTime;
    private ArrayList<String> ingredientList;

    public Recipe(String recipeName, String recipeTime, ArrayList<String> ingredientList) {
        this.recipeName = recipeName;
        this.recipeTime = recipeTime;
        this.ingredientList = ingredientList;
    }

    public void addIngrediant(String ingredient) {
        ingredientList.add(ingredient);
    }

    public String getName() {
        return recipeName;
    }

    public String getTime() {
        return recipeTime;
    }

    public ArrayList<String> getIngredientList() {
        return ingredientList;
    }

    public String toString() {
        return String.format("%s%n%s%n%s%n", getName(), getTime(), getIngredientList().toString());
    }
}
