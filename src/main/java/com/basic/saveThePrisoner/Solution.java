package main.java.com.basic.saveThePrisoner;

import java.io.*;
import java.util.stream.IntStream;

public class Solution {
    /*
     * Complete the 'saveThePrisoner' function below.
     * Link: https://www.hackerrank.com/challenges/save-the-prisoner/problem?isFullScreen=true
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER m
     *  3. INTEGER s
     */

    public static int saveThePrisoner(final int nPrisoners, int nSweets, int beginIndex) {

        nSweets = shortenTheNumberOfSweet(nPrisoners, nSweets);
        int remainingSweet = nSweets % nPrisoners;
        int shortenTimes = (remainingSweet + beginIndex) / (nPrisoners + 1);
        int index = remainingSweet + beginIndex - shortenTimes * nPrisoners - 1;
        return index == 0 ? nPrisoners : index;

    }

    private static int shortenTheNumberOfSweet(int nPrisoners, int nSweets) {
        int phanNguyen = nSweets / nPrisoners;
        nSweets = nSweets - phanNguyen * nPrisoners;
        return nSweets;
    }

    public static void main1(String[] args) {
        System.out.println(saveThePrisoner(499999999 ,999999997, 2

        ));

        //281_502_831 ?? 72975907
    }

    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("D:\\SmallProject\\PartialSort\\src\\main\\java\\com\\khang\\saveThePrisoner\\test-case.txt");
        FileWriter writer = new FileWriter("D:\\SmallProject\\PartialSort\\src\\main\\java\\com\\khang\\saveThePrisoner\\actual.txt");

        BufferedReader bufferedReader = new BufferedReader(fr);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int m = Integer.parseInt(firstMultipleInput[1]);

                int s = Integer.parseInt(firstMultipleInput[2]);

                int result = Solution.saveThePrisoner(n, m, s);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
