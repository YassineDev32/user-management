package com.example;

/**
 * A simple calculator class providing basic arithmetic operations.
 * This class offers methods for addition, subtraction, multiplication,
 * division, and square root calculations.
 *
 * @author Example
 * @version 1.0
 */
public class Calculator {

    /**
     * Adds two integers together.
     *
     * @param a the first integer operand
     * @param b the second integer operand
     * @return the sum of a and b
     */
    public int add(int a, int b) {
        return a + b;
    }

    /**
     * Subtracts the second integer from the first.
     *
     * @param a the integer to subtract from (minuend)
     * @param b the integer to subtract (subtrahend)
     * @return the difference of a minus b
     */
    public int subtract(int a, int b) {
        return a - b;
    }

    /**
     * Multiplies two integers together.
     *
     * @param a the first integer operand
     * @param b the second integer operand
     * @return the product of a and b
     */
    public int multiply(int a, int b) {
        return a * b;
    }

    /**
     * Divides the first double by the second.
     *
     * @param a the dividend (number to be divided)
     * @param b the divisor (number to divide by)
     * @return the quotient of a divided by b
     * @throws IllegalArgumentException if b is zero
     */
    public double divide(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        return a / b;
    }

    /**
     * Calculates the square root of a non-negative number.
     *
     * @param a the number to calculate the square root of
     * @return the square root of a
     * @throws IllegalArgumentException if a is negative
     */
    public double sqrt(double a) {
        if (a < 0) {
            throw new IllegalArgumentException("Cannot calculate square root of a negative number");
        }
        return Math.sqrt(a);
    }
}
