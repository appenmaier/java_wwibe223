package model;

/**
 * Fast-Food
 *
 * @author Daniel Appenmaier
 * @version 1.0
 *
 */
public record FastFood(String name, FastFoodCategory fastFoodCategory, double calorificValueInKcal,
    boolean isVegetarian) implements Comparable<FastFood> { // 1 - 1,5

  @Override // +0,5
  public int compareTo(FastFood otherFastFood) { // 0,5
    Double otherCalorificValueInKcal = otherFastFood.calorificValueInKcal; // 0,5 - 1
    return otherCalorificValueInKcal.compareTo(calorificValueInKcal); // 1
    // return Double.compare(otherFastFood.calorificValueInKcal, calorificValueInKcal); // 1,5 - 2
    // return Double.valueOf(otherFastFood.calorificValueInKcal).compareTo(calorificValueInKcal); //
    // 1,5 - 2
  } // 2 - 2,5

} // 1 - 1,5
// 3 - 4
