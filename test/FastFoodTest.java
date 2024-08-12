package test;

import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import model.FastFood;
import model.FastFoodCategory;

/**
 * FastFoodTest
 *
 * @author Daniel Appenmaier
 * @version 1.0
 *
 */
public class FastFoodTest {

  static FastFood ff1;
  static FastFood ff2;
  static FastFood ff3;

  @BeforeAll
  static void setUp() {
    ff1 = new FastFood("FF1: 5kcal", FastFoodCategory.BURGER, 5, false);
    ff2 = new FastFood("FF2: 1kcal", FastFoodCategory.BURGER, 1, false);
    ff3 = new FastFood("FF3: 1kcal", FastFoodCategory.BURGER, 1, false);
  }

  @Test
  @DisplayName("compareTo: Fast-Food 1 > Fast-Food 2: < 0")
  void testCompareTo1() {
    assertTrue(ff1.compareTo(ff2) < 0);
  }

  @Test
  @DisplayName("compareTo: Fast-Food 2 < Fast-Food 1: > 0")
  void testCompareTo2() {
    assertTrue(ff2.compareTo(ff1) > 0);
  }

  @Test
  @DisplayName("compareTo: Fast-Food 2 = Fast-Food 3: = 0")
  void testCompareTo3() {
    assertTrue(ff2.compareTo(ff3) == 0);
    assertTrue(ff3.compareTo(ff2) == 0);
  }

}
