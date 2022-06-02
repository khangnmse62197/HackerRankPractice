package main.java.com.khang.findSubstring;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static String findSubstring(String s, int k) {
        // Write your code here
        Set<String> allVowels = new HashSet<>(Arrays.asList("a", "i", "e", "u", "o"));
        String result = "";
        int count = 0;
        for (int i = 0; i <= s.length() - k; i++) {
            String tmp = s.substring(i, i + k);
            List<String> tst = Arrays.stream(tmp.split("")).collect(Collectors.toList());
            tst.retainAll(allVowels);
//            long vowelsInTmpString = Arrays.stream(tmp.split("")).filter(allVowels::contains).count();
            long vowelsInTmpString = tst.size();

            if (vowelsInTmpString == k) {
                count = (int)vowelsInTmpString;
                result = tmp;
                break;
            }
            if (vowelsInTmpString > count) {
                count = (int)vowelsInTmpString;
                result = tmp;
            }

        }

        return count == 0 ? "Not found!" : result;
    }

    public static void main(String[] args) {
        System.out.println(findSubstring("azerdii",5));
    }
}
