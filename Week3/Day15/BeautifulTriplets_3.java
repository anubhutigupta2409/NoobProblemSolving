/*
Link:-
https://www.hackerrank.com/challenges/beautiful-triplets/problem
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
     * Complete the 'beautifulTriplets' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER d
     *  2. INTEGER_ARRAY arr
     */
    
    /*
    Solution 3--> 
        //best time complexity
        //not using set, as it stores unique values and here multiple value triplets might be required
    */
    public static int beautifulTriplets(int d, List<Integer> arr) {
    // Write your code here 
    
        int res = 0;
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int i=0;i<arr.size();i++)
        {
            map.put(arr.get(i), map.getOrDefault(arr.get(i), 0)+1);
        }
        
        for(int x : map.keySet())
        {
            if(map.containsKey(x+d) && map.containsKey(x+2*d))
                res+=map.get(x);//containsKey' time complexity O(1)
        }
        
        return res;

    }

}

public class BeautifulTriplets_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int d = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.beautifulTriplets(d, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
