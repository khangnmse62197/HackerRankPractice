package main.java.com.khang.designerPDFViewer;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

  /*
   * Complete the 'designerPdfViewer' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   *  1. INTEGER_ARRAY h
   *  2. STRING word
   */

  public static int designerPdfViewer(List<Integer> h, String word) {
    // Write your code here
    Map<Character,Integer> mapIndexAndWord = new HashMap<>();
    char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

    for (int i = 0; i < h.size(); i++) {
      mapIndexAndWord.put(alphabet[i],i);
    }

    Stream<Character> charStream = word.chars().mapToObj(i->(char)i);

    Integer maxHeight = charStream
        .map(item -> h.get(mapIndexAndWord.get(item)))
        .max(Comparator.naturalOrder()).get();
    return maxHeight * word.toCharArray().length;
  }

}

public class Solution {
//  public static void main(String[] args) throws IOException {
//    BufferedReader bufferedReader = new BufferedReader(new FileReader(System.getenv("INPUT_PATH")));
//    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//    List<Integer> h = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
//        .map(Integer::parseInt)
//        .collect(toList());
//
//    String word = bufferedReader.readLine();
//
//    int result = Result.designerPdfViewer(h, word);
//
//    bufferedWriter.write(String.valueOf(result));
//    bufferedWriter.newLine();
//
//    bufferedReader.close();
//    bufferedWriter.close();
//  }
public static void main(String[] args) {
  try {
    Float f = new Float("3.0");
    int x = f.intValue();
    byte b = f.byteValue();
    double d = f.doubleValue();
    System.out.println(x + b +d);
  } catch (NumberFormatException e) {
    System.out.println("a");
  }
}
}
