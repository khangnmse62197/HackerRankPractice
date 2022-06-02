package main.java.com.khang.QueenAtack2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Solution {

  /**
   * Link https://www.hackerrank.com/challenges/queens-attack-2/problem Function Description
   * <p>
   * Complete the queensAttack function in the editor below.
   * <p>
   * queensAttack has the following parameters: - int n: the number of rows and columns in the board - nt k: the number of obstacles on the board -
   * int r_q: the row number of the queen's position - int c_q: the column number of the queen's position - int obstacles[k][2]: each element is an
   * array of  integers, the row and column of an obstacle
   * <p>
   * Returns - int: the number of squares the queen can attack
   **/
  public static int queensAttack(final int n, int k, final int r_q, final int c_q, List<List<Integer>> obstacles) {
    // Write your code here
    // 8 case possible for the Queen move. 1 -> 8
    int step = 1;

//    AtomicInteger count = new AtomicInteger(0);
    long start = System.nanoTime();

    Set<String> tmp =  obstacles.stream().map(item -> item.get(0) +"_"+item.get(1)).collect(Collectors.toSet());
    int rs = doRecursive(n, r_q, c_q, step, tmp, r_q, c_q); //init first point Queen
    System.out.println(System.nanoTime() - start); //21_524_800 148_989_500
    return rs;
  }

  private static int doRecursive(final int n, int currentIndexRow, int currentIndexCol, int step,
      final Set<String> tmp, final int r_q, final int c_q) {
    int count = 0;


    while (step < 9){
      if (step == 1){
        currentIndexRow++;
        currentIndexCol--;
      } else if (step == 2){
        currentIndexRow++;
      } else if (step == 3){
        currentIndexRow++;
        currentIndexCol++;
      }else if (step == 4){
        currentIndexCol--;
      }else if (step == 5){
        currentIndexCol++;
      }else if (step == 6){
        currentIndexRow--;
        currentIndexCol--;
      }else if (step == 7){
        currentIndexRow--;
      }else if (step == 8){
        currentIndexRow--;
        currentIndexCol++;
      }
      boolean condition1 = isValidMove(n, currentIndexRow, currentIndexCol);
      if (!condition1) {
        step++;
        currentIndexRow = r_q;
        currentIndexCol = c_q;
      } else {
        boolean condition2 = notMeetObstacles(tmp, currentIndexRow, currentIndexCol);
        if (condition2) {
//          count.incrementAndGet();
          count++;
        } else {
          step++;
          currentIndexRow = r_q;
          currentIndexCol = c_q;
        }
      }
    }
    return count;
  }

  private static boolean isValidMove(final int n, final int r, final int c) {
    boolean rowTrue = r > 0 && r <= n;
    boolean colTrue = c > 0 && c <= n;
    return rowTrue && colTrue;
  }

  private static boolean notMeetObstacles(final Set<String> tmp, final int currentIndexRow, final int currentIndexCol) {
//    if (!obstacles.isEmpty()) {
//      return obstacles.parallelStream().noneMatch(list -> list.get(0) == currentIndexRow && list.get(1) == currentIndexCol);
//    }
//    return true;
    return !tmp.contains(currentIndexRow + "_" + currentIndexCol);
  }

  public static void main(String[] args) {
    final int n = 100000;
    int k = 0;
    final int r_q = 4187;
    final int c_q = 5068;
    List<List<Integer>> obstacles = new ArrayList<>();
    System.out.println(queensAttack(n,k,r_q,c_q,obstacles ));

  }
}
