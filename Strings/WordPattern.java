package Strings;

import java.util.HashMap;

/*Given a pattern and a string s, find if s follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.



Example 1:

Input: pattern = "abba", s = "dog cat cat dog"
Output: true
Example 2:

Input: pattern = "abba", s = "dog cat cat fish"
Output: false
Example 3:

Input: pattern = "aaaa", s = "dog cat cat dog"
Output: false


Constraints:

1 <= pattern.length <= 300
pattern contains only lower-case English letters.
1 <= s.length <= 3000
s contains only lowercase English letters and spaces ' '.
s does not contain any leading or trailing spaces.
All the words in s are separated by a single space.
*/
public class WordPattern {
    public static void main(String[] args) {
        System.out.println(wordPattern("abba","dog cat cat fish"));
    }

    public static boolean wordPattern(String pattern,String s){
        int n = pattern.length();
        HashMap<Character,Integer> map1 = new HashMap<>();
        HashMap<String,Integer> map2 = new HashMap<>();
        String[] str = s.split(" ");
        if(n!=str.length) return false;
        for(int i=0;i<n;i++){
            if(map1.put(pattern.charAt(i),i)!=map2.put(str[i],i)) return false;
        }
        return true;
    }
}
