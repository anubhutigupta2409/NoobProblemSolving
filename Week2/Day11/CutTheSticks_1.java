/*
Link:-
https://www.hackerrank.com/challenges/cut-the-sticks/problem
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
     * Complete the 'cutTheSticks' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    //brute force
    private static int min(List<Integer> arr)
    {
        int min = Integer.MAX_VALUE;

        for(int x : arr)
            min = Math.min(min, x);

        return min;
    }

    public static List<Integer> cutTheSticks(List<Integer> arr) {
    // Write your code here

        List<Integer> list = new ArrayList<>();
        int min = 0;

        while(arr.size()>0)
        {
            list.add(arr.size());
            min = min(arr);
            arr.removeAll(Collections.singleton(min));//syntax to remove a collection
            //of objects, when the collection is just one object

            //.remove() just removes the first occurence of the object
        }

        return list;
    }

}

public class CutTheSticks_1{
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.cutTheSticks(arr);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}