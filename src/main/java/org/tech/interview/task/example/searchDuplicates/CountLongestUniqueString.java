package org.tech.interview.task.example.searchDuplicates;

import java.util.HashSet;
import java.util.Set;

public class CountLongestUniqueString {

    public static String TEST1 = "ASDFGHJKGKLMDUIOSOP";
    public static String TEST2 = "";
    public static String TEST3 = "";

    public static void showResult(String str) {
        System.out.println(str);
        System.out.println("Longest unique string size: " + countLongestUniqueString(str));
    }

    //  O(n)
    // sliding window
    public static int countLongestUniqueString(String str) {
        int answer = 0;
        int right = 0;
        int left = 0;
        Set<Character> set = new HashSet<>();
        while(right < str.length()) {
            Character character = str.charAt(right);
            if (set.contains(character)) {
                while(set.contains(character)) {
                    set.remove(str.charAt(left));
                    left++;
                }
            } else {
                set.add(character);
                answer = Math.max(answer, right - left + 1);
                right++;
            }
        }
        return answer;
    }

    public static int countLongestUniqueString1(String str, Set<Character> set, int left, int right, int answer) {
        if (right > str.length()) {
            return answer;
        }

        Character character = str.charAt(right);
        if (set.contains(character)) {
            while(set.contains(character)) {
                set.remove(str.charAt(left));
                left++;
            }
            return countLongestUniqueString1(str, set, left, right, answer);
        } else {
            set.add(character);
            return countLongestUniqueString1(str, set, left, ++right, Math.max(answer, right - left + 1));
        }


    }

}
