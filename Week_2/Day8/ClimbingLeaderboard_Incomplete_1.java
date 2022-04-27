/*
https://www.hackerrank.com/challenges/climbing-the-leaderboard/problem
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
     * Complete the 'climbingLeaderboard' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY ranked
     *  2. INTEGER_ARRAY player
     */


    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
    // Write your code here

        List<Integer> res = new ArrayList<>();
        List<Integer> dummy = new ArrayList<>();

        dummy.add(ranked.get(0));

        //removing douplicates
        for(int i=1;i<ranked.size();i++)
        {
            if(ranked.get(i-1)!=ranked.get(i))
                dummy.add(ranked.get(i));
        }//now ranks would be there index+1

        for(int i=0;i<player.size();i++)
        {
            if(player.get(i)>player.get(player.size()-1))
            {
                dummy.add(player.get(i));
                res.add(player.size());
            }
            else
            {
            int index = Collections.binarySearch(dummy,player.get(i),Collections.reverseOrder());

            if(index<0)
            {
                index = -1*index - 1;
                dummy.add(index, player.get(i));
            }

            res.add(index+1);
            }
        }

        return res;

    }

}

public class ClimbingLeaderboard_Incomplete_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int rankedCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> ranked = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int playerCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> player = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.climbingLeaderboard(ranked, player);

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
