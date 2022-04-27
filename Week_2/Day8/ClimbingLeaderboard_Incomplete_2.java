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

     private static int binarySearch(List<Integer> a, int key) {

    int lo = 0;
    int hi = a.size() - 1;

    while (lo <= hi) {
        int mid = lo + (hi - lo) / 2;
        if (a.get(mid) == key) {
            return mid;
        } else if (a.get(mid) < key && key < a.get(mid - 1)) {
            return mid;
        } else if (a.get(mid) > key && key >= a.get(mid + 1)) {
            return mid + 1;
        } else if (a.get(mid) < key) {
            hi = mid - 1;
        } else if (a.get(mid) > key) {
            lo = mid + 1;
        }
    }
    return -1;
}
     public static List<Integer> climbingLeaderboard(List<Integer> scores, List<Integer> alice) {
    // Write your code here

    //just write code, as you understand, simple brute force

        List<Integer> res = new ArrayList<>();
        List<Integer> rank = new ArrayList<>();//will be populated with the corresponding scores

        int n = scores.size();
        int m = alice.size();

        rank.add(1);//1st rank

        for (int i = 1; i < n; i++) {
        if (scores.get(i) == scores.get(i - 1)) {
            rank.add(i,rank.get(i - 1));
        } else {
            rank.add(i,rank.get(i - 1) + 1);
        }
    }

    for (int i = 0; i < m; i++) {
        int aliceScore = alice.get(i);
        if (aliceScore > scores.get(0)) {
            res.add(i,1);
        } else if (aliceScore < scores.get(n - 1)) {
            res.add(i,rank.get(n - 1) + 1);
        } else {
            int index = binarySearch(scores, aliceScore);
            res.add(i,rank.get(index));

        }
    }
    return res;
    }

}

public class ClimbingLeaderboard_Incomplete_2 {
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
