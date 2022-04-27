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
        
        Map<Integer,Integer> map = new HashMap<>();
        
        int res = Integer.MIN_VALUE;
        
        for(int x : a)
            map.put(x,map.getOrDefault(x,0)+1);
            
        for(int key : map.keySet())
        {
            int j = key;
            int max = 0;
            int i=0;
            
            while(i<2 && map.containsKey(j))
            {
                max+=map.get(j);
                j--;
                i++;// why i<2, coz for difference of atmost 1, the maximum number 
                    // of different elements can only 2
            }
            
            res = Math.max(max,res);
        }
        
        return res;
    }

}

public class PickingNumbers_1{
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
