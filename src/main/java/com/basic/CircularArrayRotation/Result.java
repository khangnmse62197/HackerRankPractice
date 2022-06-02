package main.java.com.basic.CircularArrayRotation;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


public class Result {
    /* Link: https://www.hackerrank.com/challenges/circular-array-rotation/problem?isFullScreen=true
     * Complete the 'circularArrayRotation' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER k
     *  3. INTEGER_ARRAY queries
     */

    public static List<Integer> circularArrayRotation(List<Integer> a, final int k, List<Integer> queries) {
        // Write your code here
        List<Integer> rs = new ArrayList<>();
        int n = a.size();
        int shortenNumberOfRotation = k - (k / n)*n;
        queries
                .forEach(ind -> {
                   rs.add(a.get(revertRotation(shortenNumberOfRotation, ind, n)));
                });

        return rs;
    }

    private static Integer revertRotation(final int k, final int newIndex, final int n) {
        int i = newIndex - k;
        if (i < 0) {
            return  n + i;
        }
        return i;
    }

    public static void main(String[] args) {
        System.out.println(
                circularArrayRotation(Arrays.asList(1,2,3), 99 , Collections.singletonList(1))
        );
    }

    public static void main2(String[] args) throws IOException {
        FileReader fr = new FileReader("D:\\SmallProject\\PartialSort\\src\\main\\java\\com\\khang\\CircularArrayRotation\\test-case.txt");
        FileWriter writer = new FileWriter("D:\\SmallProject\\PartialSort\\src\\main\\java\\com\\khang\\CircularArrayRotation\\actual.txt");

        BufferedReader bufferedReader = new BufferedReader(fr);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        int q = Integer.parseInt(firstMultipleInput[2]);

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> queries = IntStream.range(0, q).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Result.circularArrayRotation(a, k, queries);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
