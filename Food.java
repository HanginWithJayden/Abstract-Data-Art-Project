/**
 * Represents a Food with names and calories
 */
public class Food {

  private String names;     // first names of person
  private int calories;         // calories in integers

  /** Constructor */
  public Food(String names, int calories) {
    this.names = names;
    this.calories = calories;
  }

  /** Accessor Method for names */
  public String getName() {
    return names;
  }
  
  /** Accessor Method for calories */
  public int getCalories() {
    return calories;
  }
  
  /** toString Method override */
  public String toString() {
    return names + " has " + calories + " calories.";
  }
  
}