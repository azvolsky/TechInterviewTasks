package org.tech.interview.task.example.lrucache;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LruCache {
    public static final String TEST1[] = new String[] {"A", "B", "A", "C", "A", "B"};
    public static final String TEST2[] = new String[] {"A", "B", "C", "D", "E", "D", "Q", "Z", "C"};
    public static final String TEST3[] = new String[] {"A", "C", "B", "D", "E", "D", "C", "E", "B", "Q"};

    public static void showResult(String array[]) {
        System.out.println(Arrays.toString(array));
        System.out.print("LRU cache: ");
        Arrays.stream(lruCacheMap(array)).forEach(System.out::print);
        System.out.print("\n");
    }

    //  O(n)
    public static String[] lruCacheMap(String[] input) {
        return Stream
                .iterate(input.length - 1, i -> i >= 0, i -> i - 1) //revert array
                .map(i -> input[i])
                .collect(Collectors.toCollection(LinkedHashSet::new))
                .stream()
                .limit(5)
                .filter(Objects::nonNull)
                .toArray(String[]::new);
//        return positionMap.values().stream().limit(5).toArray(String[]::new);
    }
}
