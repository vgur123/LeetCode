package org.arrays;

import java.util.ArrayList;
import java.util.List;

public class BracketGenerator {
    int i =0;
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generate(n, 0, 0, "", result);
        return result;
    }

    private void generate(int n, int openCount, int closeCount, String currentString, List<String> result) {
        // Base case: if both counts reach n, a valid sequence is formed
        System.out.println("Entry " + (i++) +" - " + openCount + " " + closeCount);
        if (openCount == n && closeCount == n) {
            result.add(currentString);
            System.out.println();
            return;
        }

        // Add an opening bracket if allowed
        if (openCount < n) {
            generate(n, openCount + 1, closeCount, currentString + "(", result);
        }

        // Add a closing bracket if allowed (ensuring validity)
        if (closeCount < openCount) {
            generate(n, openCount, closeCount + 1, currentString + ")", result);
        }
    }

    public static void main(String[] args) {
        BracketGenerator generator = new BracketGenerator();
        int n = 3; // Example: Generate sequences for 3 pairs of parentheses
        List<String> sequences = generator.generateParenthesis(n);
        System.out.println("Valid bracket sequences for n = " + n + ":");
        for (String s : sequences) {
            System.out.println(s);
        }
    }
}
