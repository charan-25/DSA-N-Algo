package Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*A sentence is a string of single-space separated words where each word consists only of lowercase letters.

A word is uncommon if it appears exactly once in one of the sentences, and does not appear in the other sentence.

Given two sentences s1 and s2, return a list of all the uncommon words. You may return the answer in any order.



Example 1:

Input: s1 = "this apple is sweet", s2 = "this apple is sour"
Output: ["sweet","sour"]
Example 2:

Input: s1 = "apple apple", s2 = "banana"
Output: ["banana"]


Constraints:

1 <= s1.length, s2.length <= 200
s1 and s2 consist of lowercase English letters and spaces.
s1 and s2 do not have leading or trailing spaces.
All the words in s1 and s2 are separated by a single space.
*/
public class UnCommonWords {

    public static void main(String[] args) {
        String[] res = uncommonFromSentences("apple apple","banana");
        System.out.println(Arrays.toString(res));
    }

    public static String[] uncommonFromSentences(String s1,String s2){
        HashMap<String,Integer> map = new HashMap<>();

        String[] str1 = s1.split(" ");
        for(String s:str1) map.put(s,map.getOrDefault(s,0)+1);

        String[] str2 = s2.split(" ");
        for(String s:str2) map.put(s,map.getOrDefault(s,0)+1);

        List<String> list = new ArrayList<>();
        for(String key:map.keySet()){
            int val = map.get(key);
            if(val ==1)
                list.add(key);
        }

        return list.toArray(new String[0]);
    }
}
