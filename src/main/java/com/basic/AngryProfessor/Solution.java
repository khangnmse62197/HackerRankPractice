package main.java.com.basic.AngryProfessor;

import java.util.Arrays;
import java.util.List;

public class Solution {

  /**
    Link : https://www.hackerrank.com/challenges/angry-professor/problem
   **/
  /*
   * Complete the 'angryProfessor' function below.
   *
   * The function is expected to return a STRING.
   * The function accepts following parameters:
   *  1. INTEGER k
   *  2. INTEGER_ARRAY a
   */

  public static String angryProfessor(int k, List<Integer> a) {
    // Write your code here
    return a.stream().filter(item -> item <= 0).count() >= k ? "NO" : "YES" ;

  }



  public static void main(String[] args) {
    System.out.println(angryProfessor(1, Arrays.asList(1, 2, 0 , -1, -2)));
  }
}
