package org.easy.algorithms;

public class Factorial {

    public static void main(String[] args) {
        //E.g 4! = 4*3*2*1(factorial 4)
        System.out.println(factorial(4));
    }

    private static int factorial0(int value) {
        // A recursive function must have a condition that stops the recursion.
        if (value == 1) {
            return 1;
        } else {
            return value * factorial0(value - 1);
        }
    }

    private static int factorial(int value) {
        if (value == 1) {
            return 1;
        } else {
            int recursiveResult = factorial(value - 1);
            return recursiveResult * value;
        }
    }
}
