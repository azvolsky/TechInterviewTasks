package org.tech.interview.task.example.countDuplicates;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountDuplicates {
    public static final Integer TEST[] = {1, 2, 3, 5, 6, 4, 3, 8, 5, 3, 2};

    public static void showResult(Integer array[]) {
        System.out.println("\nCount duplicates: ");
        System.out.println(Arrays.toString(array));
        Map<Integer, Long> map = countDuplicates1(array);
        for (Integer val : map.keySet())
            System.out.println(val + " : " + map.get(val) + "\n");
        System.out.print("\n");
    }

    //  O(n)
    public static Map<Integer, Long> countDuplicates1(Integer[] input) {
        return Arrays.stream(input)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public static Map<Integer, Long> countDuplicates2(Integer[] input) {
        Map<Integer, Long> map = new HashMap<>();
        for (Integer val : input) {
            if (map.containsKey(val)) {
                map.put(val, map.get(val) + 1);
            } else {
                map.put(val, 1L);
            }
        }
        return map;
    }
}
