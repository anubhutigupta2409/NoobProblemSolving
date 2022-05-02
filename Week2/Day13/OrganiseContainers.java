/*
Link:-
https://www.hackerrank.com/challenges/organizing-containers-of-balls/problem
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
     * Complete the 'organizingContainers' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts 2D_INTEGER_ARRAY container as parameter.
     */

    /*
    Logic:-
    1) Make a table of box totals (capacity of each box)
    2) Make a table of ball totals (total quantity of each ball type)
    3) Sort both tables
    4) If they are identical print Possible, otherwise print Impossible
    */

    /*
    Why This Logic? :-
    Since "swap operation does not change the number of balls in any container", after
    all swaps, the resulting number of balls in each container should still be the same.
    That means, each type needs to occupy any one of the containers. If there is a
    missmatch, it means that type of ball has nowhere else to go and the answer is
    impossible.

    The way to approach these kind of problems is to see what things remain constant
    between the sample input and sample solution.
    */

    public static String organizingContainers(List<List<Integer>> container) {
    // Write your code here

        int n= container.size();

        int total[] = new int[n];
        int typeFrequency[] = new int[n];

        for(int i=0;i<n;i++)
        {
            int rowSum=0;
            int colSum=0;

            for(int j=0;j<n;j++)
            {
                rowSum+=container.get(i).get(j);
                colSum+=container.get(j).get(i);
            }

            total[i] = rowSum;
            typeFrequency[i] = colSum;
        }

        Arrays.sort(total);
        Arrays.sort(typeFrequency);

        for(int i=0;i<n;i++)
            if(total[i]!=typeFrequency[i])
                return "Impossible";

        return "Possible";


    }

}

public class OrganiseContainers {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<List<Integer>> container = new ArrayList<>();

                IntStream.range(0, n).forEach(i -> {
                    try {
                        container.add(
                            Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                        );
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                String result = Result.organizingContainers(container);

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
