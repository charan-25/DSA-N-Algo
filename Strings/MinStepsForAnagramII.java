package Strings;

/*You are given two strings s and t. In one step, you can append any character to either s or t.
Return the minimum number of steps to make s and t anagrams of each other.
An anagram of a string is a string that contains the same characters with a different (or the same) ordering.

Example 1:
Input: s = "leetcode", t = "coats"
Output: 7
Explanation:
- In 2 steps, we can append the letters in "as" onto s = "leetcode", forming s = "leetcodeas".
- In 5 steps, we can append the letters in "leede" onto t = "coats", forming t = "coatsleede".
"leetcodeas" and "coatsleede" are now anagrams of each other.
We used a total of 2 + 5 = 7 steps.
It can be shown that there is no way to make them anagrams of each other with less than 7 steps.

Example 2:
Input: s = "night", t = "thing"
Output: 0
Explanation: The given strings are already anagrams of each other. Thus, we do not need any further steps.

Constraints:
1 <= s.length, t.length <= 2 * 105
s and t consist of lowercase English letters.
*/

public class MinStepsForAnagramII {
    public static void main(String[] args) {
        System.out.println(minSteps("cotxazilut","nahrrmcchxwrieqqdwdpneitkxgnt"));
    }

    public static int minSteps(String s,String t){
        int[] count1 = new int[26];
        for(char ch : s.toCharArray())
            count1[ch-'a']++;
        int[] count2 = new int[26];
        for(char ch:t.toCharArray())
            count2[ch-'a']++;
        int count=0;
        for(int i=0;i<count1.length;i++){
            if(count1[i]==0 && count2[i]!=0)
                count += count2[i];
            else if(count2[i]>count1[i])
                count += (count2[i]-count1[i]);

            if(count2[i]==0 && count1[i]!=0)
                count += count1[i];
            else if(count1[i]>count2[i])
                count += (count1[i]-count2[i]);
        }
        return count;
    }
}
