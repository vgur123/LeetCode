package org.hard;

import java.util.ArrayDeque;
import java.util.Deque;

public class Calculator {
        public int calculate(String s) {
            // Stack to store intermediate results and signs when encountering parentheses
            Deque<Integer> stack = new ArrayDeque<>();

            // Current sign for the next number (1 for positive, -1 for negative)
            int currentSign = 1;

            // Running result for current expression level
            int result = 0;

            int length = s.length();

            // Iterate through each character in the string
            for (int i = 0; i < length; i++) {
                char currentChar = s.charAt(i);

                if (Character.isDigit(currentChar)) {
                    // Parse multi-digit number
                    int startIndex = i;
                    int number = 0;

                    // Continue reading digits to form the complete number
                    while (startIndex < length && Character.isDigit(s.charAt(startIndex))) {
                        number = number * 10 + (s.charAt(startIndex) - '0');
                        startIndex++;
                    }

                    // Apply the sign and add to result
                    result += currentSign * number;

                    // Update loop counter to skip processed digits
                    i = startIndex - 1;

                } else if (currentChar == '+') {
                    // Set sign for next number as positive
                    currentSign = 1;

                } else if (currentChar == '-') {
                    // Set sign for next number as negative
                    currentSign = -1;

                } else if (currentChar == '(') {
                    // Save current result and sign before processing parentheses
                    stack.push(result);
                    stack.push(currentSign);

                    // Reset for new expression inside parentheses
                    result = 0;
                    currentSign = 1;

                } else if (currentChar == ')') {
                    // Pop sign and previous result from stack
                    // Multiply current result by the sign before the parentheses
                    // Add to the result that existed before the parentheses
                    result = stack.pop() * result + stack.pop();
                }
                // Skip spaces (no action needed for space characters)
            }

            return result;
        }
    }
