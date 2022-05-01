/*
Link:-
https://www.hackerrank.com/challenges/append-and-delete/problem
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
     * Complete the 'appendAndDelete' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. STRING t
     *  3. INTEGER k
     */
    
    
    //completely correct 
    public static String appendAndDelete(String s, String t, int k) {
    // Write your code here
        
        int common = 0;
     
        
        
        for(int i=0;i<s.length() && i<t.length() ;i++)
        {
            if(s.charAt(i)==t.charAt(i))
                common++;
            else
                break;
        }
        
        if(s.length()-common + t.length()-common >k)
            return "No";
            
        else if((s.length()-common + t.length()-common)%2 == k%2)
            return "Yes";
            
        else if(s.length()+t.length()-k < 0)
            return "Yes";
            
        else
            return "No";
            
/*
Explaination --> (Taken from discussion forum)
        
CASE A:

What this case is finding is if k is bigger than the difference in length of the two strings.

example: s = "123456789", t = "1", k = 5

in this case, you definitely need a bigger k to transform s to t or vice versa, therefore you reject any such cases.

Case B:

now that the case has passed A, we can say that the total number of letters required to change is less than or equal to k.

however the next problem comes because the question specified that exactly k moves must be done, no more no less. this leads to an example whereby:

s = "010101", t = "01010", k = any EVEN number

OR

s = "010101", t = "010101", k = any ODD number

from these two examples you can see that only if k is odd/even matches the odd/even of number of different digits will such cases pass.

Case C:

However there is a way to overcome this odd/even problem if you are able to completely delete away one string as a deletion action on an empty string results in another empty string.

Example: s = '1' t = '101' k = 5

in this case, to get a S from T you could do delete-delete-delete-delete-add(1) and you will satisfy the condition.

Case D:

all other cases will fail the test
        */
    }

}

public class AppendAndDelete_Complete {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String t = bufferedReader.readLine();

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.appendAndDelete(s, t, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
