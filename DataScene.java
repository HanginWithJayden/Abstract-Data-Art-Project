import org.code.theater.*;
import org.code.media.*;

/**
 * Represents a Scene to be played in the Theater using data from
 * a choses dataset
 */
public class DataScene extends Scene {

  private Food[] foods;      // 1D array of Food objects

  /** Constructor */
  public DataScene() {
    foods = createFoods();
  }

  /** Returns a 1D array of Food objects using the txt files in this project */
  public Food[] createFoods() {
    String[] namesArray = FileReader.toStringArray("names.txt");
    int[] caloriesArray = FileReader.toIntArray("calories.txt");
    
    Food[] foodArray = new Food[namesArray.length];
    for (int i = 0; i < foodArray.length; i++) {
      foodArray[i] = new Food(namesArray[i], caloriesArray[i]);
    }

    return foodArray;
  }

  /**
   * Top-level method to draw the animation
   */

public void drawScene() {
    introScene();
    allFoodScene();
  }

  public void allFoodScene() {
    for (int i = 0; i < foods.length; i++) {
      clear("white");
      setTextStyle(Font.SANS, FontStyle.BOLD);
      setTextHeight(13);
      drawText(foods[i].getName(), 12, 100);
      setTextStyle(Font.SERIF, FontStyle.ITALIC);
      setTextHeight(16);
      drawText(foods[i].getCalories() + " calories", 12, 125);
      drawImage(getFoodImage(foods[i].getCalories()), 12, 150, 132);
      pause(1.5);
    }
  }

  public void introScene() {
      clear("white");
      setTextStyle(Font.SANS, FontStyle.BOLD);
      setTextHeight(18);
      drawText("Please take a minute to", 100, 150);
      drawText("recognize the meals and their calories", 25, 175);
      drawText("people regularly have.", 100, 200);
      pause(4);
  }

  /** Other Methods */
  public String getFoodImage(int calories) {
    if (calories < 250) {
      return "food1.png";
    } else if (calories < 277) {
      return "food3.png";
    } else {
      return "food2.png";
    }
  }
}