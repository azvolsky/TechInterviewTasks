package org.tech.interview.task.example.stack;

import java.util.Stack;

public class BracketValidator {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            // Push opening brackets onto the stack
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }
            // Check for closing brackets
            else if (c == ')' || c == '}' || c == ']') {
                // If stack is empty or top of stack doesn't match, return false
                if (stack.isEmpty()) return false;

                char top = stack.pop();
                if (!isMatchingPair(top, c)) return false;
            }
        }
        // If stack is empty, all brackets matched; otherwise, false
        return stack.isEmpty();
    }

    private static boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')') ||
                (open == '{' && close == '}') ||
                (open == '[' && close == ']');
    }

    public static void main(String[] args) {
        String test = "{[()]}"; // Example input
        System.out.println("Is the string balanced? " + isValid(test));
    }
}
