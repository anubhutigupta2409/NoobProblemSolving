/*
Link:-
https://www.hackerrank.com/challenges/happy-ladybugs/problem
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
     * Complete the 'happyLadybugs' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING b as parameter.
     */

    public static String happyLadybugs(String b) {
    // Write your code here

        //let's just check happy conditions
        //1. atleast one empty space --> no alphabet with frequency 1
        //2. no empty spaces, then already a happy string
        
        Map<Character, Integer> map = new HashMap<>();
        
        int n = b.length();
        
        if(n>1)
        {
        for(int i=0;i<n;i++)
        {
            map.put(b.charAt(i), map.getOrDefault(b.charAt(i),0)+1);
        }
        
        //check for frequency of an alphabet
        for(int i=0;i<n;i++)
        {
            char ch = b.charAt(i);
            if(ch!='_')
                if(map.get(ch)==1)
                    return "NO";
        }
        if(!map.containsKey('_'))
        {
            //check if it's happy or not
            for(int i=0;i<n;i++)
            {
                int ch = b.charAt(i);
                
                if((i+1<n && ch != b.charAt(i+1)) || (i-1>=0 && ch != b.charAt(i-1)))
                    return "NO";
                    
            }
        }
        }
        return "YES";
    }

}

public class HappyLadyBugs_1{
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int g = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, g).forEach(gItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                String b = bufferedReader.readLine();

                String result = Result.happyLadybugs(b);

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
