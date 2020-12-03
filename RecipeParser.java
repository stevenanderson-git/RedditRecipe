import java.io.File;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * From Reddit:
 * https://www.reddit.com/r/javahelp/comments/k5k5mk/reading_from_a_txt_file_and_storing_it_to/
 * 
 * @author u/lordwerwath
 */
public class RecipeParser {
    private ArrayList<Recipe> cookbook;

    public RecipeParser() {
        cookbook = new ArrayList<>();
        // These variables are only assigned if the file is successfully opened
        String recipeName = "";
        String recipeTime = "";
        String ingredient = "";
        ArrayList<String> ingredientList = new ArrayList<>();

        try (Scanner docScanner = new Scanner(new File("cookbook.txt"))) {
            // reads the document till the end
            while (docScanner.hasNext()) {
                // loop to create each recipe
                recipeName = docScanner.nextLine(); // always the same at the beginning of each loop
                recipeTime = docScanner.nextLine(); // always the same at the beginning of each loop
                // this loop will always execute at least once
                do {
                    ingredient = docScanner.nextLine();
                    // add the ingredient to the list
                    ingredientList.add(ingredient);
                } while (!ingredient.equals("")); // loop will end if the ingredient is the empty string.
                // all values for the recipe are now stored in variables. We can create a recipe
                // object and begin the loop again
                // and add recipe to the cookbook
                cookbook.add(new Recipe(recipeName, recipeTime, ingredientList));
                // clears the ingredient list to be ready for next recipe.
                ingredientList = new ArrayList<>();
            }
        } catch (NoSuchElementException nse) {
            // this will catch any errors if there is an abrupt end to the document.
            // Check to make sure that a blank recipe is not added in error.
            if (!recipeName.equals("")) {
                try {
                    cookbook.add(new Recipe(recipeName, recipeTime, ingredientList));
                } catch (Exception e) {
                    // If the above does not work, there is insufficient information for final
                    // recipe.
                    System.out.println("Insufficient information to complete recipe.");
                }
            }
        } catch (Exception e) {
            System.out.println("Woops no file found for: " + e.toString());
        }
        // prints out each Recipie in cookbook to the terminal
        for (Recipe r : cookbook) {
            System.out.println(r.toString());
        }
    }
}
