/*
Link:-
https://www.hackerrank.com/challenges/acm-icpc-team/problem
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
     * Complete the 'acmTeam' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts STRING_ARRAY topic as parameter.
     */

    public static List<Integer> acmTeam(List<String> topic) {
    // Write your code here

        int max = Integer.MIN_VALUE;//maximum number of topics
        int count = 1;//count of teams w max no of topics

        for(int i=0;i<topic.size()-1;i++)
        {
            for(int j=i+1;j<topic.size();j++)
            {
                int temp = 0;

                for(int k=0;k<topic.get(i).length();k++)
                    if(topic.get(i).charAt(k)=='1' || topic.get(j).charAt(k)=='1')
                        temp++;

                if(temp>max)
                {
                    max = temp;
                    count = 1;
                }
                else if(temp==max)
                    count++;
            }
        }

        List<Integer> res = new ArrayList<>();

        res.add(max);
        res.add(count);

        return res;

    }

}

public class ACM_ICPC_Team {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<String> topic = IntStream.range(0, n).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        List<Integer> result = Result.acmTeam(topic);

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
