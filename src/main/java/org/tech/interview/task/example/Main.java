package org.tech.interview.task.example;

import org.tech.interview.task.example.countDuplicates.CountDuplicates;
import org.tech.interview.task.example.lrucache.LruCache;
import org.tech.interview.task.example.searchDuplicates.CountLongestUniqueString;
import org.tech.interview.task.example.searchDuplicates.MaxLengthBetweenDuplicates;

public class Main {
    private final static String array[] = new String[] {"A", "B", "A", "C", "A", "B"};
    private final static String array1[] = new String[] {"A", "B", "C", "D", "E", "D", "Q", "Z", "C"};
    private final static String array2[] = new String[] {"A", "C", "B", "D", "E", "D", "C", "E", "B", "Q"};

    public static void main(String[] args) {
        CountLongestUniqueString.showResult(CountLongestUniqueString.TEST1);
        LruCache.showResult(LruCache.TEST1);
        MaxLengthBetweenDuplicates.showResult(MaxLengthBetweenDuplicates.TEST1);
        CountDuplicates.showResult(CountDuplicates.TEST);
    }
}