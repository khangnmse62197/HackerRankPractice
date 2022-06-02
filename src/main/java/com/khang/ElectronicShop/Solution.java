package main.java.com.khang.ElectronicShop;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] keyboards, int[] drives, int b) {
        AtomicInteger atomicInteger = new AtomicInteger(Integer.MAX_VALUE);
        AtomicInteger maxTotal = new AtomicInteger(0);
        Arrays.stream(keyboards).forEach(keyboard -> Arrays.stream(drives).forEach(usb -> {
            int totalTmp = keyboard + usb;
            if (b - totalTmp >= 0 && b - totalTmp < atomicInteger.get()) {
                atomicInteger.set(b - totalTmp);
                maxTotal.set(totalTmp) ;
            }
        }));
        return maxTotal.get() == 0 ? -1 : maxTotal.get();
    }



    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[]{1,2}, new int[]{1,2,6}, 20));
    }
}