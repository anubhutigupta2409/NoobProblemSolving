/*
Link:-
https://www.hackerrank.com/challenges/fair-rations/problem
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
     * Complete the 'fairRations' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts INTEGER_ARRAY B as parameter.
     */

    public static String fairRations(List<Integer> B) {
    // Write your code here
    
        int res = 0;
        
        int sum = 0;
        
        for(int x : B)
            sum+=x;
            
        if((sum&1)==1)
            return "NO";// if sum is even only then it is possible, since we are adding 
            //one, to two elements at a time
            
        for(int i=0;i<B.size();i++)
        {
            if((B.get(i)&1) == 1)
            {
                B.set(i, B.get(i)+1);//not required
                B.set(i+1 , B.get(i+1)+1);//bounding not required, as if possible, last element wont be odd
                res+=2;
            }
        }
        
        return String.valueOf(res);

    }

}

public class FairRatio_2{
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int N = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> B = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        String result = Result.fairRations(B);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
