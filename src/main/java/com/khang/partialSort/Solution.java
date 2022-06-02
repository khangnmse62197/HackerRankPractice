package main.java.com.khang.partialSort;

import java.util.*;

class Solution {
    public String solution(String S, int K) {
        // write your code in Java SE 8
        for(int i = 0; i < K ; i++) {
            int min = Integer.MAX_VALUE;
            String willReplaceS = "";
            List<String> possibleSwap = this.possibleSwap(S);

            for(String str: possibleSwap) {
                int tmp = str.compareTo(S);
                if (tmp < min) {
                    min = tmp;
                    willReplaceS = str;
                }
            }

            S = willReplaceS;
        }
        return S;
    }

    private List<String> possibleSwap(String s) {
        final char[] str = s.toCharArray(); //split by each charactor
        List<String> result = new ArrayList<>();
        for(int i = 0; i < str.length - 1 ; i++) {
            char[] copy = s.toCharArray();
            char tmp = copy[i + 1];
            copy[i + 1] = copy[i];
            copy[i] = tmp;
            result.add(new String(copy));
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("decade",4));
    }
}