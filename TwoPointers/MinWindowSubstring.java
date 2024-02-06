package TwoPointers;
/*Given two strings s and t of lengths m and n respectively, return the minimum window
substring
 of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".

The testcases will be generated such that the answer is unique.



Example 1:

Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
Example 2:

Input: s = "a", t = "a"
Output: "a"
Explanation: The entire string s is the minimum window.
Example 3:

Input: s = "a", t = "aa"
Output: ""
Explanation: Both 'a's from t must be included in the window.
Since the largest window of s only has one 'a', return empty string.


Constraints:

m == s.length
n == t.length
1 <= m, n <= 105
s and t consist of uppercase and lowercase English letters.


Follow up: Could you find an algorithm that runs in O(m + n) time?*/
import java.util.HashMap;

public class MinWindowSubstring {

    public static void main(String[] args) {
        System.out.println(minWindowString("ADOBECODEBANC","ABC"));
    }

    public static String minWindowString(String s,String t){
        HashMap<Character,Integer> map = new HashMap<>();
        for(char ch:t.toCharArray()) map.put(ch,map.getOrDefault(ch,0)+1);

        int left=0,right=0,m=t.length(),n=s.length(),minStart=0,minLength = Integer.MAX_VALUE;
        while(right<n){
            char ch = s.charAt(right);
            if(map.containsKey(ch)){
                if(map.get(ch) >0)
                    m--;
                map.put(ch,map.get(ch)-1);
            }

            while(m==0){
                if(right-left+1 < minLength){
                    minStart = left;
                    minLength = right-left+1;
                }

                char c = s.charAt(left);
                if(map.containsKey(c)){
                    map.put(c,map.get(c)+1);
                    if(map.get(c) > 0)
                        m++;
                }
                left++;
            }
            right++;
        }

        return minLength ==Integer.MAX_VALUE ? "" : s.substring(minStart,minStart+minLength);
    }
}
