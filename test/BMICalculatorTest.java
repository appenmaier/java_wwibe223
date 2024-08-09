package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import model.BMICalculator;
import model.InvalidValueException;

/**
 * BMICalculatorTest
 *
 * @author Daniel Appenmaier
 * @version 1.0
 *
 */
public class BMICalculatorTest {

  BMICalculator calculator;

  @BeforeEach
  void setUp() throws InvalidValueException {
    calculator = new BMICalculator(85, 1.8);
  }

  @Test
  void testConstructor() {
    assertThrows(InvalidValueException.class, () -> new BMICalculator(0, 1));
    assertThrows(InvalidValueException.class, () -> new BMICalculator(1, 0));
  }

  @Test
  void testGetBMI() {
    assertTrue(Math.abs(calculator.getBMI() - 26.234) <= 0.001);
  }

  @Test
  void testGetBMICategory() {
    assertEquals("Uebergewicht", calculator.getBMICategory());
  }

}
