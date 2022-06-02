package main.java.com.khang.nab;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {

  public String solution(String S, int K) {
    String[] mess = S.split(" ");
    StringBuilder result = new StringBuilder();
    List<String> finalStr = Arrays.stream(mess).filter(str -> !str.isEmpty()).collect(Collectors.toList());
    for (String s : finalStr) {
      if ((result + s).length() <= K) {
        result.append(s).append(" ");
      } else {
        break;
      }
    }

    return result.toString().trim(); // remove the space at the end
  }


  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.solution("To crop     or    not         to crop         ", 21));
  }
}