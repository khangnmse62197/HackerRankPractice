package main.java.com.intermidiate.nonDivisibleSubset;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    private static boolean isContinue = false;
    private static Integer MAX_KEY = 0;
    private static int MAX_VALUE = 0;
    public static int nonDivisibleSubset(int k, List<Integer> s) {
//        System.out.println(ranking(s,k));
        ranking2(s, k);
        while (isContinue) {
            isContinue = false;
            if (s.remove(MAX_KEY)) {
                MAX_KEY = 0;
                MAX_VALUE = 0;
                ranking2(s, k);
            }
        }
        return s.size();
    }

    private static Map<Integer, Integer> ranking(List<Integer> s, int k) {
        return s.stream()
                .collect(Collectors.toMap(
                        key -> key,
                        value -> {
                            int count = 0;
                            for (Integer item : s) {
                                if ((item + value) % k == 0 && (!item.equals(value))) {
                                    count++;
                                    isContinue = true;
                                }

                                if (count >= MAX_VALUE) {
                                    MAX_VALUE = count;
                                    MAX_KEY = item;
                                }
                            }
                            return count;
                        }
                ));

    }
    private static void ranking2(List<Integer> s, int k) {
        for (Integer value: s) {
            int count = 0;
            for (Integer item : s) {
                if ((item + value) % k == 0 && (!item.equals(value))) {
                    count++;
                    isContinue = true;
                }

                if (count >= MAX_VALUE) {
                    MAX_VALUE = count;
                    MAX_KEY = value;
                }
            }
        }
    }


    private static boolean isEnd(List<Integer> s, int k) {
        return s.stream()
                .anyMatch(item -> s.stream().anyMatch(item2 -> !item2.equals(item) && ((item + item2) % k == 0)));
    }



    public static void main(String[] args) {
        System.out.println(nonDivisibleSubset(7, new ArrayList<>(Arrays.asList(278,576,496,727,410,124,338,149,209,702,282,718,771,575,436))));
//        System.out.println(nonDivisibleSubset(5, new ArrayList<>(Arrays.asList(2,7, 12, 17, 22))));
//        System.out.println(nonDivisibleSubset(4, new ArrayList<>(Arrays.asList(1,7,2,4,5))));
    }
}
