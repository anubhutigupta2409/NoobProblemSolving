/*
Link:-
https://www.hackerrank.com/challenges/repeated-string/problem
*/

/*

//noob solution TLE

public static long repeatedString(String s, long n) {
    // Write your code here

        int a = 0;

        while(n>0)
        {
            for(int i=0; n>0 && i<s.length(); i++)
            {
                if(s.charAt(i)=='a')
                    a++;
                n--;
            }
        }

        return a;

    }

}

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
     * Complete the 'repeatedString' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. LONG_INTEGER n
     */

    public static long repeatedString(String s, long n) {
    // Write your code here

        long res = 0;

        //count in the original string
        for(int i=0;i<s.length();i++)
            if(s.charAt(i)=='a')
                res++;

        //how many complete strings can be formed in the given n
        long comp = n/s.length();

        //how many letters will be left (the remaining part of the string)
        long left = n%s.length();

        res = comp*res;//complete strings' a's

        //now calculate a's in the remaining string
        for(int i=0;i<left;i++)
            if(s.charAt(i)=='a')
                res++;

        return res;
    }

}

public class RepeatedString{
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        long n = Long.parseLong(bufferedReader.readLine().trim());

        long result = Result.repeatedString(s, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}