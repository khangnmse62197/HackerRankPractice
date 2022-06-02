package main.java.com.basic.cutTheSticks;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution {
    /* Link: https://www.hackerrank.com/challenges/cut-the-sticks
     * Complete the 'cutTheSticks' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static List<Integer> cutTheSticks(List<Integer> arr) {
        // Write your code here
        Map<Integer, Long> sortedItemMapWithItsCount = arr.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        List<Integer> keySet = sortedItemMapWithItsCount.keySet().stream().sorted().collect(Collectors.toList());

        List<Integer> result = new ArrayList<>();
        int previousKey = 0;
        for (Integer groupedItem: keySet) {
            final int newKey = groupedItem - previousKey;
            HashMap<Integer, Long> reduceMap = new HashMap<>();
            AtomicLong count = new AtomicLong(sortedItemMapWithItsCount.remove(newKey));
            sortedItemMapWithItsCount.forEach( (key, value) -> {
                if (key - newKey != 0) { //won't count stick have size == 0 in next ground
                    reduceMap.put((key - newKey),value);
                }
                count.set(count.get() + value); //count all sticks are reduced
            });
            result.add((int) count.get());
            previousKey = groupedItem; // save previous key
            sortedItemMapWithItsCount = reduceMap;

        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(cutTheSticks(new ArrayList<>(Arrays.asList(5, 4, 4, 2, 2, 8))));
    }
}
