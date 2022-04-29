/*
Link:-
https://www.hackerrank.com/challenges/strange-advertising/problem
*/

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
     * Complete the 'viralAdvertising' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER n as parameter.
     */

    //using recursion
    //right shift by 1 of a particular number divides it by 2
    private static int viralAdvertising(int days, int n)
    {
        return days==0 ? 0 : (n>>1) + viralAdvertising(--days, (n>>1)*3) ;
    }
    public static int viralAdvertising(int days) {
    // Write your code here

        return viralAdvertising(days, 5);

    }

}

public class StrangeAdvertising_Recursion {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int result = Result.viralAdvertising(n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
