/*
Link:-
https://www.hackerrank.com/challenges/jumping-on-the-clouds/problem
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
     * Complete the 'jumpingOnClouds' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY c as parameter.
     */


    public static int jumpingOnClouds(List<Integer> c) {
    // Write your code here

        int jump =0;
        int n = c.size();

        /*
        inference-->

        1. we are taking atleast one jump everytime
        2. if the further +2 cloud is also safe, we can take a longer jump
        3. if not, then one unit jump also works.
        */

        for(int i=0;i<n-1; i++, jump++)
        {
            if(i<n-2 && c.get(i+2)==0)
                i++;
        }

        return jump;
    }

}

public class JumpingOnClouds {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> c = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.jumpingOnClouds(c);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
