/*
Link:-
https://www.hackerrank.com/challenges/sherlock-and-squares/problem
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
     * Complete the 'squares' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER a
     *  2. INTEGER b
     */
     
     //optimised
    private static boolean isSquare(int a)
    {
        double x = Math.sqrt(a);
        
        return Math.floor(x) == Math.ceil(x) ? true : false;
    }
    public static int squares(int a, int b) {
    // Write your code here
        
       
        int first=0, last=0;
        
        //find the first square number 
        for(int i=a;i<=b;i++)
        {
            if(isSquare(i))
            {
                first = (int)Math.sqrt(i);
                break;
            }
        }
        
        //find last sq no
        for(int i=b;i>=a;i--)
        {
            if(isSquare(i))
            {
                last = (int)Math.sqrt(i);
                break;
            }
        }
                
                
        return last!=0 && first!=0 ? last-first+1 : 0;
    }

}

public class SherlockSquares_Optimised {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int a = Integer.parseInt(firstMultipleInput[0]);

                int b = Integer.parseInt(firstMultipleInput[1]);

                int result = Result.squares(a, b);

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
