package main.java.com.basic.extraLongFactorials;
import java.io.*;
import java.math.*;

import static java.util.stream.Collectors.joining;

class Result {

    /*
     * Complete the 'extraLongFactorials' function below.
     *
     * The function accepts INTEGER n as parameter.
     */

    public static void extraLongFactorials(int n) {
        // Write your code here
        BigInteger result = new BigInteger("" + 1);
        for(int i = 1; i <= n; i++) {
            result = result.multiply(new BigInteger("" + i));
        }
        System.out.print(result);
    }

}

public class Solution {
    public static void main2(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        Result.extraLongFactorials(n);

        bufferedReader.close();
    }

    public static void main(String[] args) {
        Result.extraLongFactorials(22);
    }
}
