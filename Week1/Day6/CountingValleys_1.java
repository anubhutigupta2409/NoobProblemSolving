/*
Link:-
https://www.hackerrank.com/challenges/counting-valleys/problem
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
     * Complete the 'countingValleys' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER steps
     *  2. STRING path
     */

    public static int countingValleys(int steps, String path) {
    // Write your code here

        int res = 0;

        int seaLevel = 0;
        boolean valley = false;

        for(int i=0;i<path.length();i++)
        {
            if(path.charAt(i)=='U')
                seaLevel+=1;
            else if(path.charAt(i)=='D')
                seaLevel-=1;

            if(seaLevel<0)
                valley = true;

            if(seaLevel>=0 && valley)
            {
                res+=1;
                valley = false;
            }
        }

        return res;

    }

}

public class CountingValleys_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int steps = Integer.parseInt(bufferedReader.readLine().trim());

        String path = bufferedReader.readLine();

        int result = Result.countingValleys(steps, path);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
