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

        boolean flag=false;
        if(b.length()==1&&b.charAt(0)!='_'){
            return "NO";
        }
        int count=0;
        for(int i=0;i<b.length();i++){
            if(b.charAt(i)=='_'){
                flag=true;
                count++;
            }
        }
        if(count==b.length()){
            return "YES";
        }
        if(flag==false){
            for(int i=1;i<b.length();i++){
                if(i==b.length()-1){
                    if(b.charAt(i)!=b.charAt(i-1)){
                        return "NO";
                    }
                    return "YES";
                }
                if(b.charAt(i)!=b.charAt(i-1)&&b.charAt(i)!=b.charAt(i+1)){
                    return "NO";
                }
                
            }
            return "YES";
        }
        else{
            char[] arr=b.toCharArray();
            Arrays.sort(arr);
            if(arr[0]!=arr[1]){
                return "NO";
            }
            for(int i=1;i<arr.length;i++){
                if(arr[i]=='_'){
                    if(arr[i-1]!=arr[i-2]){
                        return "NO";
                    }
                    return "YES";
                }
                if(arr[i]!=arr[i-1]&&arr[i]!=arr[i+1]){
                    return "NO";
                }
            
            }
        }
        return "YES";
    }

}

public class HappyLadyBugs_2 {
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
