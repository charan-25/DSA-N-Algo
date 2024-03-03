package Strings;

import java.util.HashMap;

/*Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome that can be built with those letters.
Letters are case sensitive, for example, "Aa" is not considered a palindrome here.

Example 1:
Input: s = "abccccdd"
Output: 7
Explanation: One longest palindrome that can be built is "dccaccd", whose length is 7.

Example 2:
Input: s = "a"
Output: 1
Explanation: The longest palindrome that can be built is "a", whose length is 1.

Constraints:
1 <= s.length <= 2000
s consists of lowercase and/or uppercase English letters only.
*/
public class LongestPalindrome {
    public static void main(String[] args) {
        System.out.println(bruteLongestPalindromeCount("abccccdd"));
        System.out.println(longestPalindromeCount("abccccdd"));
    }

    public static int bruteLongestPalindromeCount(String str){
        HashMap<Character,Integer> map = new HashMap<>();
        for(char ch:str.toCharArray())map.put(ch,map.getOrDefault(ch,0)+1);
        int count =0;
        boolean odd = false;
        for(char key : map.keySet()){
            if(map.get(key)%2==1) {
                count += map.get(key) - 1;
                odd = !odd;
            }
            else
                count += map.get(key);
        }
        return count+= odd?0:1;
    }

    public static int longestPalindromeCount(String str){
        int[] count = new int[256];
        for(char ch :str.toCharArray())
            count[ch]++;
        boolean odd = false;
        int ans = 0;
        for(int i =62;i<256;i++){
            if(count[i]%2==0)
                ans += count[i];
            else{
                odd = !odd;
                ans += count[i]-1;
            }
        }
        return ans+= odd ?0:1;
    }
}
