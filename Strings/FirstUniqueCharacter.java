package Strings;

/*Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.



Example 1:

Input: s = "leetcode"
Output: 0
Example 2:

Input: s = "loveleetcode"
Output: 2
Example 3:

Input: s = "aabb"
Output: -1


Constraints:

1 <= s.length <= 105
s consists of only lowercase English letters.*/

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacter {
    public static void main(String[] args) {
    //    System.out.println(firstUniqChar("loveleetcode"));
        System.out.println(bruteFirstUniqChar("loveleetcode"));
    }

    //Brute Force TC:O(N) SC:O(N)
    public static int bruteFirstUniqChar(String str){
        Map<Character,Integer> map = new HashMap<>();
        int ans = Integer.MAX_VALUE;
        for(char ch :str.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }

        for(Map.Entry entry : map.entrySet()){
            if(entry.getValue().equals(1)){
                int index = str.indexOf((char)entry.getKey());
                ans = Math.min(ans,index);
            }
        }
        return ans==Integer.MAX_VALUE ? -1 : ans;
    }

    //Optimized Approach
    public static int firstUniqChar(String str){
        int ans = Integer.MAX_VALUE;
        for(char c = 'a';c<='z';c++){
            int index = str.indexOf(c);
            if(index!=-1 && index==str.lastIndexOf(c)){
                ans = Math.min(ans,index);
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
