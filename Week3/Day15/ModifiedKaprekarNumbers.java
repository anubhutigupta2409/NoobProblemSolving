/*
Link:-
https://www.hackerrank.com/challenges/kaprekar-numbers/problem
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
     * Complete the 'kaprekarNumbers' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER p
     *  2. INTEGER q
     */
    
    //inference --> we can easily play with a number's digits by converting it into a string :)
    private static boolean isKaprekar(int n)
    {
        long sq = (long) n*n;
        String squared = String.valueOf(sq);
        
        //now the left and the right part
        String left = squared.substring(0, squared.length()/2);
        String right = squared.substring(squared.length()/2);
        
        int numL = left.isEmpty() ? 0 : Integer.parseInt(left);//if it's empty, make it 0
        int numR = right.isEmpty() ? 0 : Integer.parseInt(right);
        
        return numL+numR == n;
    }
    public static void kaprekarNumbers(int p, int q) {
    // Write your code here
        
        boolean ans = false;
        for(int i=p;i<=q;i++)
        {
            if(isKaprekar(i))
            {
                System.out.print(i+" ");
                ans = true;
            }
        }
        
        if(!ans)
            System.out.print("INVALID RANGE");
    }

}

public class ModifiedKaprekarNumbers{
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int p = Integer.parseInt(bufferedReader.readLine().trim());

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        Result.kaprekarNumbers(p, q);

        bufferedReader.close();
    }
}

