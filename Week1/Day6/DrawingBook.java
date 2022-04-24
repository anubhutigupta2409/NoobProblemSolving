/*
Link:-
https://www.hackerrank.com/challenges/drawing-book/problem
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
     * Complete the 'pageCount' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER p
     */

    public static int pageCount(int n, int p) {
    // Write your code here
    
        int res=0;
        
        /*
        from front, number of pages to turn = (p-1)/2 <-- ceil value
        from back, number of pages to turn if total pages is -->
            even = (n-p)/2 <-- ceil value
            odd = (n-p)/2 <-- floor value
        */
        
        if(n>1)
        {   
            int x = p-1;
            double fCount = Math.ceil((double)x/2.0);
            
            double bCount;
            int y = n-p;
            
            if(n%2==0)
                bCount = Math.ceil((double)y/2.0);
            
            else
                bCount = Math.floor((double)y/2.0);
                
            res = (int)Math.min(fCount, bCount);
        }
        
        return res;

    }

}

public class DrawingBook{
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int p = Integer.parseInt(bufferedReader.readLine().trim());

        int result = Result.pageCount(n, p);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
