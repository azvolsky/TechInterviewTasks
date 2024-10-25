package org.tech.interview.task.example.searchDuplicates;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MaxLengthBetweenDuplicates {

    public static final String TEST1 = "ASDFGHJKGKLMDUIOSOP";
    public static final String TEST2 = "AASDDFGH";
    public static final String TEST3 = "ASDFGZ";

    public static void showResult(String str) {
        System.out.println(str);
        System.out.println("Max length between duplicates: " + maxLengthBetweenDuplicates(str));
    }

//  O(n)
    public static int maxLengthBetweenDuplicates(String s) {
        // Map to store the first occurrence of each character
        HashMap<Character, Integer> firstOccurrence = new HashMap<>();

        // Variable to store the maximum length of the substring between duplicates
        int maxLength = 0;

        // Iterate through the string
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            // If the character has been seen before, calculate the length of the substring
            if (firstOccurrence.containsKey(currentChar)) {
                int firstIndex = firstOccurrence.get(currentChar);
                int currentLength = i - firstIndex - 1;
                maxLength = Math.max(maxLength, currentLength);
            } else {
                // If it's the first occurrence of the character, store its index
                firstOccurrence.put(currentChar, i);
            }
        }

        return maxLength;
    }

    public static int maxLengthBetweenDuplicates2(String s) {
        // Map to store the first occurrence of each character
        Map<Character, Integer> firstOccurrence = new HashMap<>();

        // Stream over the indices of the string
        OptionalInt maxLength = IntStream.range(0, s.length())
                .map(i -> {
                    char currentChar = s.charAt(i);
                    // If the character has been seen before, calculate the length
                    if (firstOccurrence.containsKey(currentChar)) {
                        int firstIndex = firstOccurrence.get(currentChar);
                        return i - firstIndex - 1;
                    } else {
                        // Store the first occurrence of the character
                        firstOccurrence.put(currentChar, i);
                        return -1;  // Return -1 if no duplicate found for this character yet
                    }
                })
                .filter(length -> length >= 0) // Filter out the -1s (no duplicates found)
                .max(); // Get the maximum length if any

        // Return the result, or 0 if no duplicates were found
        return maxLength.orElse(0);
//        return Arrays.stream(s.split("")).collect(Collectors.groupingBy(i -> i, ));
    }
}
