/*
Link:-
https://www.hackerrank.com/challenges/the-grid-search/problem
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
     * Complete the 'gridSearch' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING_ARRAY G
     *  2. STRING_ARRAY P
     */

    public static String gridSearch(List<String> G, List<String> P) {
    // Write your code here
        
        //till the difference, since if we cannot find the pattern till the difference
        //then it doesnot exists
        for(int i=0;i<=(G.size()-P.size());i++)
        {
            for(int j=0;j<=(G.get(0).length()-P.get(0).length());j++)
            {
                int a = i;
                int c = 0;
                
                //for starters first we check if the first row of the pattern is found
                if(G.get(i).substring(j,j+P.get(0).length()).equals(P.get(0)))
                {
                    //if yes then we continue to find it further
                    c++;
                    for(int k=1;k<P.size();k++)
                    {
                        i++;
                        if(G.get(i).substring(j,j+P.get(0).length()).equals(P.get(k)))
                            c++;
                        else
                            break;//one unequal comparison proves non existence of the 
                                  //pattern
                    }
                    
                    if(c==P.size())
                        return "YES";//to check if we checked all the rows
                }
                i=a;//as we manipulated the value of i, inside
            }
        }
        
        return "NO";

    }

}

public class GridSearch {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int R = Integer.parseInt(firstMultipleInput[0]);

                int C = Integer.parseInt(firstMultipleInput[1]);

                List<String> G = IntStream.range(0, R).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                    .collect(toList());

                String[] secondMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int r = Integer.parseInt(secondMultipleInput[0]);

                int c = Integer.parseInt(secondMultipleInput[1]);

                List<String> P = IntStream.range(0, r).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                    .collect(toList());

                String result = Result.gridSearch(G, P);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
