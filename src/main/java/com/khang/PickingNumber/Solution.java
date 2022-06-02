package main.java.com.khang.PickingNumber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution {

  /**
   * Link https://www.hackerrank.com/challenges/picking-numbers/problem
   * Given an array of integers, find the longest subarray where the absolute difference between any two elements is less than or equal to .
   * Function Description
   *
   * Complete the pickingNumbers function in the editor below.
   *
   * pickingNumbers has the following parameter(s):
   *
   * int a[n]: an array of integers
   * Returns
   * int: the length of the longest subarray that meets the criterion
   **/
  public static int pickingNumbers(List<Integer> a) {
    // Write your code here

   a =  a.stream().sorted().collect(Collectors.toList());

   int rs = 0;
    for (int i = 0; i < a.size(); i++) {
      List<Integer> tmp = new ArrayList<>();
      tmp.add(a.get(i));
      for (int j = i + 1; j < a.size(); j++) {
        if (Math.abs(a.get(i) - a.get(j)) < 2) {
          tmp.add(a.get(j));
        } else {
          break;
        }
      }

      if (tmp.size() > rs) rs = tmp.size();
    }
    return rs;
  }


  public static void main(String[] args) {

    List<Integer> a = new ArrayList<>(
        Arrays.asList(1,2,4,2,4,5,4,5)
    );

    System.out.println(pickingNumbers(a));

  }
}
