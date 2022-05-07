/*
Link:-
https://www.hackerrank.com/challenges/fair-rations/problem
*/

//brute force, fails 6/22 testcases

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
    
    private static boolean isEven(int x)
    {
        return (x&1)==0 ? true : false;
    }
    private static boolean isValid(int i, int n)
    {
        return i<n && i>=0;
    }
    public static String fairRations(List<Integer> B) {
    // Write your code here
    
        int res = 0;
        int n = B.size();
        
        for(int i=0;i<B.size();i++)
        {
            int x = B.get(i);
            
            if(!isEven(x))
            {
                B.set(i,x+1);
                res++;
                
                if(!isValid(i-1, n) && isValid(i+1, n))
                    return "NO";
                    
                    
                if((isValid(i-1, n) && !isEven(B.get(i-1))) || !isValid(i+1, n))
                {
                    B.set(i-1,B.get(i-1)+1);
                    res++;
                }
                    
                else if(isValid(i+1, n))
                {
                    B.set(i+1,B.get(i+1)+1);
                    res++;
                }
            }
        }
        
        for(int x : B)
            if(!isEven(x))
                return "NO";
                
        return String.valueOf(res);

    }

}

public class FairRatio_1 {
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
