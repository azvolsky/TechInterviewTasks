package org.tech.interview.task.example.lrucache;

import java.util.Iterator;
import java.util.LinkedHashSet;

public class LRUCacheSet extends LinkedHashSet<String> {
    private final int cacheSize;

    // Constructor to set the maximum cache size
    public LRUCacheSet(int size) {
        super(size);
        this.cacheSize = size;
    }

    // Method to access elements and update cache (LRU logic)
    public void access(String element) {
        // If the element is already in the cache, remove it (to refresh its position)
        if (this.contains(element)) {
            this.remove(element);
        }
        // Add the element to the cache (this moves it to the front)
        this.add(element);

        // If the cache exceeds the allowed size, remove the least recently used element (first one)
        if (this.size() > cacheSize) {
            // Remove the least recently used element (the first inserted)
            Iterator<String> iterator = this.iterator();
            if (iterator.hasNext()) {
                String leastUsed = iterator.next();
                this.remove(leastUsed);
            }
        }
    }

    // Method to return the cache contents as a hyphen-separated string
    public String getCacheContents() {
        return String.join("-", this);
    }

    public void main(String[] args) {
        // Input string array
        String[] strArr = {"A", "B", "C", "D", "A", "E", "D", "Z"};

        // Initialize the LRU cache with a size of 5
        LRUCacheSet lruCache = new LRUCacheSet(5);

        // Access elements as per the input array
        for (String s : strArr) {
            lruCache.access(s);
        }

        // Output the final cache contents
        System.out.println(lruCache.getCacheContents());  // Expected output: "C-A-E-D-Z"
    }
}
