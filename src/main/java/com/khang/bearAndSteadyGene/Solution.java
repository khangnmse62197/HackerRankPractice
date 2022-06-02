package main.java.com.khang.bearAndSteadyGene;

import com.sun.xml.internal.ws.util.StringUtils;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

  /*
   * Complete the 'steadyGene' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts STRING gene as parameter.
   */

  public static int steadyGene(String gene) {
    // Write your code here
//    String s = "TGATGCCGTCCCCTCAACTTGAGTGCTCCTAATGCGTTGC";
    String[] s2 = gene.split("");

    final int average = gene.length() / 4;

    Map<String,Long> collect = Stream.of(s2).collect(groupingBy(item -> item, counting()));
    Set<String> ignore = new HashSet<>();

    List<String> abc = new ArrayList<>();
    int min2 = 0;
    for (Map.Entry<String,Long> tmp : collect.entrySet()
    ) {
      if (tmp.getValue() > average) {
        abc.addAll(
            IntStream.range(0, (int) (tmp.getValue() - average)).boxed().map(item -> tmp.getKey()).collect(toList())
        );
        min2 = min2 + ((int) (tmp.getValue() - average));
      } else {
        ignore.add(tmp.getKey());
      }
    }
    if (abc.isEmpty()) return 0;

    int min = Integer.MAX_VALUE;

    for (int i = 0; i < s2.length; i++) {

      if (min == min2) break;
      if (ignore.contains(s2[i])) continue;

      List<String> clone = new LinkedList<>(abc);
      for (int j = i; j < s2.length; j++) {
        if (ignore.contains(s2[j])) continue;
        clone.remove(s2[j]);
        if (clone.size() == 0) {
          min = Math.min(min,j - i + 1);
          break;
        }
      }
    }
    return min ;
  }

  public static int steadyGene2(String gene) {


    List<String> s3 = new ArrayList<>(Arrays.asList(gene.split("")));
    final int average = gene.length() / 4;

    Map<String,Long> collect = s3.stream().collect(groupingBy(item -> item, counting()));
    Set<String> notIgnore = new HashSet<>();

    for (Map.Entry<String,Long> tmp : collect.entrySet()
    ) {
      if (tmp.getValue() > average) {
        s3.replaceAll(item -> item.equals(tmp.getKey()) ? " " : item);
      }
    }

    return 1;




  }

  private static boolean isBalance(final Map<String,Long> collectedNeed, String substring){
    Map<String,Long> collect = Stream.of(substring.split("")).collect(groupingBy(item -> item, counting()));
    for(Map.Entry<String,Long> tmp : collectedNeed.entrySet()) {
      if (!tmp.getValue().equals(collect.get(tmp.getKey()))){
        return false;

      }
    }
    return true;
  }

}

public class Solution {
  public static void main(String[] args) throws IOException {
//    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//    int n = Integer.parseInt(bufferedReader.readLine().trim());
//
//    String gene = bufferedReader.readLine();
//
//    int result = Result.steadyGene(gene);
//
//    bufferedWriter.write(String.valueOf(result));
//    bufferedWriter.newLine();
//
//    bufferedReader.close();
//    bufferedWriter.close();


  }

}

