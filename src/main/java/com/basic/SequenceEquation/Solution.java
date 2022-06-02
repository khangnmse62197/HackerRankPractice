package main.java.com.basic.SequenceEquation;

public class Solution {

  /**
    Link : https://www.hackerrank.com/challenges/permutation-equation/problem
   **/

  /*
   * Complete the 'permutationEquation' function below.
   *
   * The function is expected to return an INTEGER_ARRAY.
   * The function accepts INTEGER_ARRAY p as parameter.
   */

  static int jumpingOnClouds(int[] c, int k) {
    int energy = 100;
    int n = c.length;
    for(int i = 0; i < n; i = i + k){
      if ( i == 0) continue;
      if (i == (n - k)) {
        energy = minmusEnergy(energy, c[0]);
      }
        energy = minmusEnergy(energy, c[i]);
    }
    return energy;
  }
  private static int minmusEnergy(int energy, int valueAtIIndex){
    return valueAtIIndex == 1 ? (energy - 3) : (energy - 1);
  }



  public static void main(String[] args) {
    System.out.println(
        jumpingOnClouds(new int[]{ 0,0,1,0,0,1,1,0 } , 2));

  }
}
