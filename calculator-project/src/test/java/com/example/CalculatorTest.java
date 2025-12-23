package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the Calculator class.
 * This test class provides comprehensive coverage for all Calculator operations
 * including normal cases, edge cases, and exception handling.
 */
@DisplayName("Calculator Tests")
class CalculatorTest {

    private Calculator calculator;

    /**
     * Initializes a new Calculator instance before each test.
     */
    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    // ==================== ADDITION TESTS ====================

    @Nested
    @DisplayName("Addition Tests")
    class AdditionTests {

        @Test
        @DisplayName("Should add two positive numbers correctly")
        void testAddPositiveNumbers() {
            assertEquals(5, calculator.add(2, 3));
        }

        @Test
        @DisplayName("Should add two negative numbers correctly")
        void testAddNegativeNumbers() {
            assertEquals(-5, calculator.add(-2, -3));
        }

        @Test
        @DisplayName("Should add a positive and negative number correctly")
        void testAddMixedNumbers() {
            assertEquals(-1, calculator.add(2, -3));
        }

        @Test
        @DisplayName("Should return the same number when adding zero")
        void testAddWithZero() {
            assertEquals(5, calculator.add(5, 0));
            assertEquals(5, calculator.add(0, 5));
        }

        @Test
        @DisplayName("Should return zero when adding zero to zero")
        void testAddZeroToZero() {
            assertEquals(0, calculator.add(0, 0));
        }
    }

    // ==================== SUBTRACTION TESTS ====================

    @Nested
    @DisplayName("Subtraction Tests")
    class SubtractionTests {

        @Test
        @DisplayName("Should subtract two positive numbers correctly")
        void testSubtractPositiveNumbers() {
            assertEquals(2, calculator.subtract(5, 3));
        }

        @Test
        @DisplayName("Should subtract two negative numbers correctly")
        void testSubtractNegativeNumbers() {
            assertEquals(1, calculator.subtract(-2, -3));
        }

        @Test
        @DisplayName("Should subtract a negative from a positive number correctly")
        void testSubtractNegativeFromPositive() {
            assertEquals(8, calculator.subtract(5, -3));
        }

        @Test
        @DisplayName("Should return the same number when subtracting zero")
        void testSubtractZero() {
            assertEquals(5, calculator.subtract(5, 0));
        }

        @Test
        @DisplayName("Should return negative when subtracting from zero")
        void testSubtractFromZero() {
            assertEquals(-5, calculator.subtract(0, 5));
        }
    }

    // ==================== MULTIPLICATION TESTS ====================

    @Nested
    @DisplayName("Multiplication Tests")
    class MultiplicationTests {

        @Test
        @DisplayName("Should multiply two positive numbers correctly")
        void testMultiplyPositiveNumbers() {
            assertEquals(15, calculator.multiply(5, 3));
        }

        @Test
        @DisplayName("Should multiply two negative numbers to get a positive result")
        void testMultiplyNegativeNumbers() {
            assertEquals(6, calculator.multiply(-2, -3));
        }

        @Test
        @DisplayName("Should multiply a positive and negative number to get a negative result")
        void testMultiplyMixedNumbers() {
            assertEquals(-15, calculator.multiply(5, -3));
        }

        @Test
        @DisplayName("Should return zero when multiplying by zero")
        void testMultiplyByZero() {
            assertEquals(0, calculator.multiply(5, 0));
            assertEquals(0, calculator.multiply(0, 5));
        }

        @Test
        @DisplayName("Should return the same number when multiplying by one")
        void testMultiplyByOne() {
            assertEquals(5, calculator.multiply(5, 1));
            assertEquals(5, calculator.multiply(1, 5));
        }
    }

    // ==================== DIVISION TESTS ====================

    @Nested
    @DisplayName("Division Tests")
    class DivisionTests {

        @Test
        @DisplayName("Should divide two positive numbers correctly")
        void testDividePositiveNumbers() {
            assertEquals(2.5, calculator.divide(5, 2), 0.0001);
        }

        @Test
        @DisplayName("Should divide two negative numbers to get a positive result")
        void testDivideNegativeNumbers() {
            assertEquals(2.0, calculator.divide(-6, -3), 0.0001);
        }

        @Test
        @DisplayName("Should divide a positive by a negative number to get a negative result")
        void testDivideMixedNumbers() {
            assertEquals(-2.0, calculator.divide(6, -3), 0.0001);
        }

        @Test
        @DisplayName("Should return zero when dividing zero by a non-zero number")
        void testDivideZeroByNumber() {
            assertEquals(0.0, calculator.divide(0, 5), 0.0001);
        }

        @Test
        @DisplayName("Should throw IllegalArgumentException when dividing by zero")
        void testDivideByZero() {
            IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> calculator.divide(5, 0)
            );
            assertEquals("Cannot divide by zero", exception.getMessage());
        }

        @Test
        @DisplayName("Should handle division of decimal numbers correctly")
        void testDivideDecimalNumbers() {
            assertEquals(2.5, calculator.divide(5.0, 2.0), 0.0001);
        }
    }

    // ==================== SQUARE ROOT TESTS ====================

    @Nested
    @DisplayName("Square Root Tests")
    class SquareRootTests {

        @Test
        @DisplayName("Should calculate square root of a positive number correctly")
        void testSqrtPositiveNumber() {
            assertEquals(3.0, calculator.sqrt(9), 0.0001);
        }

        @Test
        @DisplayName("Should calculate square root of zero correctly")
        void testSqrtZero() {
            assertEquals(0.0, calculator.sqrt(0), 0.0001);
        }

        @Test
        @DisplayName("Should calculate square root of one correctly")
        void testSqrtOne() {
            assertEquals(1.0, calculator.sqrt(1), 0.0001);
        }

        @Test
        @DisplayName("Should calculate square root of a decimal number correctly")
        void testSqrtDecimalNumber() {
            assertEquals(1.5, calculator.sqrt(2.25), 0.0001);
        }

        @Test
        @DisplayName("Should throw IllegalArgumentException for negative number")
        void testSqrtNegativeNumber() {
            IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> calculator.sqrt(-4)
            );
            assertEquals("Cannot calculate square root of a negative number", exception.getMessage());
        }

        @Test
        @DisplayName("Should calculate square root of a large number correctly")
        void testSqrtLargeNumber() {
            assertEquals(100.0, calculator.sqrt(10000), 0.0001);
        }
    }

    // ==================== ADDITIONAL EDGE CASE TESTS ====================

    @Nested
    @DisplayName("Edge Case Tests")
    class EdgeCaseTests {

        @Test
        @DisplayName("Should handle Integer.MAX_VALUE in addition")
        void testAddWithMaxValue() {
            // This will overflow, but we're testing the behavior
            int result = calculator.add(Integer.MAX_VALUE, 1);
            assertEquals(Integer.MIN_VALUE, result);
        }

        @Test
        @DisplayName("Should handle Integer.MIN_VALUE in subtraction")
        void testSubtractWithMinValue() {
            // This will overflow, but we're testing the behavior
            int result = calculator.subtract(Integer.MIN_VALUE, 1);
            assertEquals(Integer.MAX_VALUE, result);
        }

        @Test
        @DisplayName("Should calculate sqrt of 2 correctly (irrational result)")
        void testSqrtIrrationalResult() {
            assertEquals(1.4142, calculator.sqrt(2), 0.001);
        }

        @Test
        @DisplayName("Should divide small numbers correctly")
        void testDivideSmallNumbers() {
            assertEquals(0.5, calculator.divide(1, 2), 0.0001);
        }
    }
}
