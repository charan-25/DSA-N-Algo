package Strings;


import java.util.Arrays;

/*You are given two strings of the same length s and t. In one step you can choose any character of t and replace it with another character.
Return the minimum number of steps to make t an anagram of s.
An Anagram of a string is a string that contains the same characters with a different (or the same) ordering.

Example 1:
Input: s = "bab", t = "aba"
Output: 1
Explanation: Replace the first 'a' in t with b, t = "bba" which is anagram of s.

Example 2:
Input: s = "leetcode", t = "practice"
Output: 5
Explanation: Replace 'p', 'r', 'a', 'i' and 'c' from t with proper characters to make t anagram of s.

Example 3:
Input: s = "anagram", t = "mangaar"
Output: 0
Explanation: "anagram" and "mangaar" are anagrams.

Constraints:
1 <= s.length <= 5 * 104
s.length == t.length
s and t consist of lowercase English letters only.
*/
public class MinStepsForAnagram {
    public static void main(String[] args) {
        System.out.println(minSteps("leetcode","practice"));
    }

    public static int minSteps(String s,String t){
        int[] count = new int[26];
        for(char ch : s.toCharArray())
            count[ch-'a']++;
        System.out.println(Arrays.toString(count));
        for(char ch : t.toCharArray())
            count[ch-'a']--;
        System.out.println(Arrays.toString(count));
        int sum=0;
        for(int i=0;i<count.length;i++){
            if(count[i]>0)
                sum += count[i];
        }
       // System.out.println(sum);
        return sum;
    }
}
