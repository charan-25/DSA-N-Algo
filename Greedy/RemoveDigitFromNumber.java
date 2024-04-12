package Greedy;

import java.util.ArrayList;
import java.util.Collections;

/*You are given a string number representing a positive integer and a character digit.

Return the resulting string after removing exactly one occurrence of digit from number such that the value of the resulting string in decimal form is maximized. The test cases are generated such that digit occurs at least once in number.



Example 1:

Input: number = "123", digit = "3"
Output: "12"
Explanation: There is only one '3' in "123". After removing '3', the result is "12".
Example 2:

Input: number = "1231", digit = "1"
Output: "231"
Explanation: We can remove the first '1' to get "231" or remove the second '1' to get "123".
Since 231 > 123, we return "231".
Example 3:

Input: number = "551", digit = "5"
Output: "51"
Explanation: We can remove either the first or second '5' from "551".
Both result in the string "51".


Constraints:

2 <= number.length <= 100
number consists of digits from '1' to '9'.
digit is a digit from '1' to '9'.
digit occurs at least once in number.
*/
public class RemoveDigitFromNumber {
    public static void main(String[] args) {
        System.out.println(optimizedRemoveDigits("133235",'3'));
        System.out.println(bruteRemoveDigits("133235",'3'));
    }

    public static String optimizedRemoveDigits(String number,char digit){
        int n = number.length();
        int j = 0;
        for(int i=0;i<n;i++){

            if(number.charAt(i)==digit){
                j = i;
                if(i+1 < n && number.charAt(i+1)>digit) break;
            }
        }
        return number.substring(0,j)+number.substring(j+1);
    }

    public static String bruteRemoveDigits(String number,char digit){
        int n = number.length();
        ArrayList<String> res = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(number.charAt(i)==digit){
                String temp = number.substring(0,i)+number.substring(i+1);
                res.add(temp);
            }
        }
        Collections.sort(res);
        int len = res.size();
        return res.get(len-1);
    }
}
