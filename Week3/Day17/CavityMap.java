/*
Link:-
https://www.hackerrank.com/challenges/cavity-map/problem
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
     * Complete the 'cavityMap' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts STRING_ARRAY grid as parameter.
     */

    public static List<String> cavityMap(List<String> grid) {
        
    // Write your code here
    
        int n = grid.size();
        
        for(int i=1;i<n-1;i++)
        {
            String x = grid.get(i);
            
            for(int j=1;j<n-1;j++)
            {
                int a = x.charAt(j-1);
                int b = x.charAt(j+1);
                int c = grid.get(i-1).charAt(j);
                int d = grid.get(i+1).charAt(j);
                
                int xx = x.charAt(j);
                
                if(xx>a && xx>b && xx>c && xx>d)
                {
                    grid.set(i,x.substring(0,j)+'X'+x.substring(j+1));
                }
            }
        }
        
        return grid;

    }

}

public class CavityMap {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> grid = IntStream.range(0, n).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        List<String> result = Result.cavityMap(grid);

        bufferedWriter.write(
            result.stream()
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
