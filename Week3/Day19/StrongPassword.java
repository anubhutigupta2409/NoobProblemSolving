/*
Link:-
https://www.hackerrank.com/challenges/strong-password/problem
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
     * Complete the 'minimumNumber' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. STRING password
     */

    public static int minimumNumber(int n, String p) {
    // Return the minimum number of characters to make the password strong

    int digit=0, lo=0, up=0, sp=0 ;

        //number of conditions to fulfill = 4

        for(int i=0;i<n;i++)
        {
            char ch = p.charAt(i);

            if(Character.isDigit(ch))
                digit = 1;

            else if(Character.isLowerCase(ch))
                lo = 1;

            else if(Character.isUpperCase(ch))
                up = 1;

            else if(ch=='!' ||ch=='@'||ch=='#'||ch=='$'||ch=='%'||ch=='^'||ch=='&'||ch=='*'||ch=='('||ch==')'||ch=='-'||ch=='+')

                sp=1;

        }

        //now number of characters to be added
        int res = 4 - (digit+sp+lo+up);

        //if less than 6
        if(n+res<6)
            return 6-n;
        else
            return res;


    }

}

public class StrongPassword {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String password = bufferedReader.readLine();

        int answer = Result.minimumNumber(n, password);

        bufferedWriter.write(String.valueOf(answer));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
