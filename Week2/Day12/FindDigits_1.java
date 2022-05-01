/*
Link:-
https://www.hackerrank.com/challenges/find-digits/problem
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
     * Complete the 'findDigits' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER n as parameter.
     */
    
    //extract digits
    private static List<Integer> extract(int n)
    {
        List<Integer> digits = new ArrayList<>();
        
        while(n>0)
        {
            int digit = n%10;
            digits.add(digit);
            n/=10;
        }
        
        return digits;
    }   
    public static int findDigits(int n) {
    // Write your code here
        
        int res = 0;
        
        List<Integer> digits = new ArrayList<>();
        
        digits = extract(n);
        
        for(int i=0;i<digits.size();i++)
        {
            int digit = digits.get(i);
            
            if(digit!=0 && n%digit == 0)
                res++;
        }
        
        return res;
        

    }

}

public class FindDigits_1{
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                int result = Result.findDigits(n);

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

