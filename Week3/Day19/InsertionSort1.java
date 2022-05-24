/*
Link:-
https://www.hackerrank.com/challenges/insertionsort1/problem
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
     * Complete the 'insertionSort1' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY arr
     */
    
    public static void print(List<Integer> arr){
        
        for(int x : arr)
        {
            System.out.print(x+" ");
        }
    }
    public static void insertionSort1(int n, List<Integer> arr) {
    // Write your code here
    
        int i = n-1;
        int key = arr.get(i);
        
        while(i>0 && arr.get(i-1)>key)
        {
            arr.set(i, arr.get(i-1));
            print(arr);
            System.out.println();
            i--;
        }
        
        arr.set(i,key);
        print(arr);
    }

}

public class InsertionSort1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        Result.insertionSort1(n, arr);

        bufferedReader.close();
    }
}
