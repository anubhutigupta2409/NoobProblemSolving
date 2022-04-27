/*
Link:-
https://www.hackerrank.com/challenges/beautiful-days-at-the-movies/problem
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
     * Complete the 'beautifulDays' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER i
     *  2. INTEGER j
     *  3. INTEGER k
     */

    //returns reversed number
    private static int reverse(int n)
    {
        int res = 0;

        while(n>0)
        {
            res = res*10 + n%10;
            n/=10;
        }

        return res;
    }
    public static int beautifulDays(int i, int j, int k) {
    // Write your code here

        int res = 0;
        int diff=0;

        for(int n=i ; n<=j ; n++)
        {
            diff = Math.abs(n-reverse(n));

            if(diff%k == 0)
                res++;
        }

        return res;

    }

}

public class BeautifulDays{
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int i = Integer.parseInt(firstMultipleInput[0]);

        int j = Integer.parseInt(firstMultipleInput[1]);

        int k = Integer.parseInt(firstMultipleInput[2]);

        int result = Result.beautifulDays(i, j, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
