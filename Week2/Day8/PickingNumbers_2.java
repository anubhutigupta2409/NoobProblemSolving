/*
https://www.hackerrank.com/challenges/picking-numbers/problem
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
     * Complete the 'pickingNumbers' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static int pickingNumbers(List<Integer> a) {
    // Write your code here
        
        /*
        the question says they want set of all those number which differ only by 1 or 0.

        So by this we know our answer set will include some number say x and x+1. i.e.           they would be consequtive.

        Now all we need to do is find frequency of all the numbers in the given question.

        and find a consecutive pair whose frequencies when added up would be max.
        */
        
        //method-2
        
        int res = Integer.MIN_VALUE;
        
        int freq[] = new int[101];
        
        for(int x : a)
            freq[x]++;
            
        for(int i=1;i<=100;i++)
            res = Math.max(freq[i]+freq[i-1] ,res);
            
        return res;
    }

}

public class PickingNumbers_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.pickingNumbers(a);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
