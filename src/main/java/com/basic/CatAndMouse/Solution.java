package main.java.com.basic.CatAndMouse;

import java.io.*;
import java.util.*;

public class Solution {

  // Complete the catAndMouse function below.

  /**
   * Two cats and a mouse are at various positions on a line. You will be given their starting positions.
   * Your task is to determine which cat will reach the mouse first, assuming the mouse does not move and the cats travel at equal speed.
   * If the cats arrive at the same time, the mouse wil be allowed to move and it will escape while they fight.
   *
   * You are given  queries in the form of , , and  representing the respective positions for cats  and , and for mouse .
   * Complete the function  to return the appropriate answer to each query, which will be printed on a new line.
   *
   * @param x Cat A
   * @param y Cat B
   * @param z Mouse C
   * @return
   *  If cat  catches the mouse first, print Cat A.
   *  If cat  catches the mouse first, print Cat B.
   *  If both cats reach the mouse at the same time, print Mouse C as the two cats fight and mouse escapes.
   *
   *  Example
   *  x = 2
   *  y = 5
   *  z = 4
   * The cats are at positions  2 (Cat A) and  5 (Cat B), and the mouse is at position 4.
   * Cat B, at position 5 at position  will arrive first since it is only  unit away while the other is  units away. Return 'Cat B'.
   */
  static String catAndMouse(int x, int y, int z) {
    int distanceA = Math.abs(x - z);
    int distanceB = Math.abs(y - z);

    if (distanceA == distanceB) return "Mouse C";
    return distanceA > distanceB ? "Cat B" : "Cat A";
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    int x= 2;
    int y= 5;
    int z= 4;
    System.out.println(catAndMouse( x,y,z));
  }
}
