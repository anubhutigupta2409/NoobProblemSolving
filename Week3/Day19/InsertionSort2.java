/*
Link:-
https://www.hackerrank.com/challenges/insertionsort2/problem
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
     * Complete the 'insertionSort2' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY arr
     */

    public static void print(List<Integer> arr)
    {
        for(int x : arr)
            System.out.print(x+" ");
    }
    public static void insertionSort2(int n, List<Integer> arr) {
    // Write your code here
    
        //starting from 1
        
        for(int i=1;i<n;i++)
        {
            int curr = arr.get(i);//curr element
            
            //now insertion
            
            int j = i-1;
            
            while(j>=0 && arr.get(j)>curr)
            {
                arr.set(j+1, arr.get(j));
                j--;
            }
            
            arr.set(j+1, curr);
            print(arr);
            System.out.println();
        }

    }

}

public class InsertionSort2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        Result.insertionSort2(n, arr);

        bufferedReader.close();
    }
}
 
