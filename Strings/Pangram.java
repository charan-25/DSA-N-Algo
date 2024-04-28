package Strings;
/*A pangram is a sentence where every letter of the English alphabet appears at least once.

Given a string sentence containing only lowercase English letters, return true if sentence is a pangram, or false otherwise.



Example 1:

Input: sentence = "thequickbrownfoxjumpsoverthelazydog"
Output: true
Explanation: sentence contains at least one of every letter of the English alphabet.
Example 2:

Input: sentence = "leetcode"
Output: false


Constraints:

1 <= sentence.length <= 1000
sentence consists of lowercase English letters.*/
public class Pangram {
    public static void main(String[] args) {
        System.out.println(checkIfPangram("thequickbrownfoxjumpsoverthelazydog"));
    }


    public static boolean checkIfPangram(String sentence) {
        int[] count = new int[26];
        if(sentence.length()<26) return false;
        for(char ch: sentence.toCharArray()) count[ch-'a']++;

        for(int  i=0;i<count.length;i++){
            if(count[i]<1) return false;
        }
        return true;
    }
}
