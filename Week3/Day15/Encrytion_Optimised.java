/*
Link:-
https://www.hackerrank.com/challenges/encryption/problem
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
     * Complete the 'encryption' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */
    
    //space optmised
    public static String encryption(String s) {
    // Write your code here
        
        String newStr = "";//remove spaces
        
        for(int i =0;i<s.length();i++)
            if(s.charAt(i)!=' ')
                newStr+=s.charAt(i);
                
        int x = newStr.length();
        
        int rows = (int)Math.floor((double)Math.sqrt(x));
        int cols = (int)Math.ceil((double)Math.sqrt(x));
        
        int counter = 0;
        
        while(rows*cols < x)
        {
            if(counter%2==0)
                rows++;
            else
                cols++;
                
            counter++;
        }
        
        String res="";
        
        int i=0;
        
        while(i<cols)
        {
            int curr = i;
            while(curr<x)
            {
                res+=newStr.charAt(curr);
                curr+=cols;
            }
            res+=" ";
            i++;
        }
        return res;
    }

}

public class Encrytion_Optimised{
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.encryption(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
