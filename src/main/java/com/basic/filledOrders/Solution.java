package main.java.com.basic.filledOrders;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public static int filledOrders(List<Integer> orders, int k) {
        // Write your code here
        final int kForFilter = k ;
        orders = orders.stream().filter(order -> order <= kForFilter).sorted().collect(Collectors.toList());

        int result = 0;
        for (int item : orders) {
            if (item <= k) {
                k = k - item;
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(filledOrders(Arrays.asList(1,23,4,5,123,145,12), 30));
    }
}
