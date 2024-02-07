package Sorting;
/*Given a string s, sort it in decreasing order based on the frequency of the characters.
The frequency of a character is the number of times it appears in the string.
Return the sorted string. If there are multiple answers, return any of them.

Example 1:
Input: s = "tree"
Output: "eert"
Explanation: 'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.

Example 2:
Input: s = "cccaaa"
Output: "aaaccc"
Explanation: Both 'c' and 'a' appear three times, so both "cccaaa" and "aaaccc" are valid answers.
Note that "cacaca" is incorrect, as the same characters must be together.

Example 3:
Input: s = "Aabb"
Output: "bbAa"
Explanation: "bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters.

Constraints:
1 <= s.length <= 5 * 105
s consists of uppercase and lowercase English letters and digits.*/
import java.util.*;

public class FrequencySort {

    public static void main(String[] args) {
        System.out.println(frequencySort("abbcccdddd1234455667799999000000"));
    }

    public static String frequencySort(String str){
        Map<Character,Integer> map = new HashMap<>();
        for(Character ch :str.toCharArray()) map.put(ch,map.getOrDefault(ch,0)+1);
        StringBuilder sb = new StringBuilder();
        LinkedHashMap<Character,Integer> ans = sortMapByValues(map);
        for(Map.Entry entry:ans.entrySet()){
            int val = (Integer) entry.getValue();
            for(int i=0;i<val;i++){
                sb.append(entry.getKey());
            }
        }
        return new String(sb);
    }

    public static LinkedHashMap<Character,Integer> sortMapByValues(Map<Character,Integer> map){
        LinkedList<Map.Entry<Character,Integer>> list = new LinkedList<>(map.entrySet());
        Collections.sort(list,(Map.Entry<Character,Integer> a,Map.Entry<Character,Integer> b) ->
        {
            Integer val1 = a.getValue();
            Integer val2 = b.getValue();
            if(val1.equals(val2))
                return val1.compareTo(val2);
            else
                return val2.compareTo(val1);
        });
        LinkedHashMap<Character,Integer> res = new LinkedHashMap<>();
        for(Map.Entry<Character,Integer> entry:list) res.put((Character) entry.getKey(),(Integer) entry.getValue());
        return res;
    }
}
