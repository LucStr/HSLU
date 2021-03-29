package ch.hslu.oop.exercises.calculator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
final class CalculatorTests {
    ICalculator calculator;

    @BeforeAll
    void setupCalculator() {
        calculator = new Calculator();
    }

    @Test
    void testAdditionWithTwoNumbers() {
        var result = calculator.addition(1, 2);

        assertEquals(3, result);
    }

    @Test
    void testAdditionWithNegativeNumbers() {
        var result = calculator.addition(1, -2);

        assertEquals(-1, result);
    }

    @Test
    void testAdditionOfZeros() {
        var result = calculator.addition(0, 0);

        assertEquals(0, result);
    }
}
